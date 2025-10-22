# Task & Expense Tracker — Backend (Spring Boot)["Backend"]

Backend service for tracking tasks and expenses. Built with **Spring Boot 3 (Java 23)**, **Hibernate/JPA**, **PostgreSQL**, **MapStruct**, **Flyway**, secured with **JWT**, documented via **OpenAPI/Swagger**, and containerized with **Docker**.



---

## ✨ Features

**MVP**

* User authentication (**register/login**) with JWT.
* CRUD **Tasks**: title, description, status (TODO/DOING/DONE), priority, due date.
* CRUD **Expenses**: date, amount, currency, category, note.
* **Categories** for tasks and expenses (user-scoped).
* Pagination, sorting, and filtering on list endpoints.
* OpenAPI docs + Swagger UI.

**Nice to have**

* Budgets per category/month with alerts.
* Soft delete & audit fields (createdAt/updatedAt).
* CSV import/export.
* Metrics (Micrometer) & health checks (Actuator).

---

## 🧰 Tech Stack

* **Java **23**, **Spring Boot 3**

  * spring-boot-starter-web, validation (Jakarta)
  * **spring-boot-starter-data-jpa** (Hibernate)
  * **spring-boot-starter-security** (JWT)
  * **Flyway** for DB migrations
  * **springdoc-openapi** for Swagger
* **PostgreSQL 16**
* **MapStruct** for DTO ↔ Entity mapping
* Testing: **JUnit 5**, **Mockito**, **Testcontainers (PostgreSQL)**
* **Docker** & **Docker Compose**

---

## 📦 Project Structure

```
backend/
├─ src/main/java/com/example/tracker/
│  ├─ TrackerApplication.java
│  ├─ config/           # security, OpenAPI, CORS
│  ├─ auth/             # controllers, services, JWT utils
│  ├─ task/             # entity, dto, mapper, repo, service, controller
│  ├─ expense/
│  ├─ category/
│  └─ common/           # exceptions, constants, utils
├─ src/main/resources/
│  ├─ application.yml
│  └─ db/migration/     # Flyway SQL files (V1__*.sql ...)
├─ src/test/java/…      # unit & integration tests
└─ pom.xml
```

---

## 🗃️ Data Model (proposal)

Tables:

* **users**: `id`, `email` (unique), `password_hash`, `display_name`, `roles`, `created_at`
* **category**: `id`, `name`, `type` (`TASK|EXPENSE`), `user_id`
* **task**: `id`, `title`, `description`, `status`, `priority`, `due_date`, `category_id`, `user_id`, `created_at`, `updated_at`
* **expense**: `id`, `amount`, `currency`, `date`, `note`, `category_id`, `user_id`, `created_at`

Suggested indexes: `(user_id)`, `(category_id)`, `(date)`, `(status, due_date)`.

**Flyway `V1__init.sql` (example):**

```sql
CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  display_name VARCHAR(120),
  roles VARCHAR(120) NOT NULL DEFAULT 'USER',
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE category (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(120) NOT NULL,
  type VARCHAR(16) NOT NULL CHECK (type IN ('TASK','EXPENSE')),
  user_id BIGINT NOT NULL REFERENCES users(id)
);

CREATE TABLE task (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  description TEXT,
  status VARCHAR(16) NOT NULL DEFAULT 'TODO',
  priority VARCHAR(16) NOT NULL DEFAULT 'MEDIUM',
  due_date DATE,
  category_id BIGINT REFERENCES category(id),
  user_id BIGINT NOT NULL REFERENCES users(id),
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE expense (
  id BIGSERIAL PRIMARY KEY,
  amount NUMERIC(12,2) NOT NULL,
  currency CHAR(3) NOT NULL DEFAULT 'EUR',
  date DATE NOT NULL,
  note TEXT,
  category_id BIGINT REFERENCES category(id),
  user_id BIGINT NOT NULL REFERENCES users(id),
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
```

---

## 🔌 REST API (draft)

### Auth

* `POST /api/auth/register` → 201 Created
* `POST /api/auth/login` → `{ accessToken, refreshToken }`
* Use `Authorization: Bearer <token>` for protected endpoints.

### Tasks

* `GET /api/tasks?status=&page=&size=&sort=` – paginated list
* `POST /api/tasks` – create
* `GET /api/tasks/{id}` – details
* `PUT /api/tasks/{id}` – update
* `DELETE /api/tasks/{id}` – delete (optional soft delete)

### Expenses

* `GET /api/expenses?from=&to=&category=&page=&size=`
* `POST /api/expenses`
* `GET /api/expenses/{id}`
* `PUT /api/expenses/{id}`
* `DELETE /api/expenses/{id}`

### Categories

* `GET /api/categories?type=TASK|EXPENSE`
* `POST /api/categories`
* `PUT /api/categories/{id}`
* `DELETE /api/categories/{id}`

### Reports

* `GET /api/reports/expenses/monthly?year=2025`
* `GET /api/reports/expenses/by-category?month=2025-10`

**Swagger UI:** `http://localhost:8080/swagger-ui.html`

---

## 🔁 MapStruct

**Maven deps:**

```xml
<dependency>
  <groupId>org.mapstruct</groupId>
  <artifactId>mapstruct</artifactId>
  <version>1.5.5.Final</version>
</dependency>
<dependency>
  <groupId>org.mapstruct</groupId>
  <artifactId>mapstruct-processor</artifactId>
  <version>1.5.5.Final</version>
  <scope>provided</scope>
</dependency>
```

**Example mapper:**

```java
@Mapper(componentModel = "spring")
public interface TaskMapper {
  TaskDto toDto(Task entity);
  Task toEntity(TaskCreateRequest dto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void update(@MappingTarget Task entity, TaskUpdateRequest dto);
}
```

---

## ⚙️ Configuration

`src/main/resources/application.yml` (dev example):

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/tracker
    username: app
    password: app
  jpa:
    hibernate:
      ddl-auto: validate
    open-in-view: false
  flyway:
    enabled: true
  servlet:
    multipart:
      max-file-size: 5MB
      max-request-size: 5MB

app:
  security:
    jwt-secret: change-me
    access-token-ttl: 15m
    refresh-token-ttl: 7d
```

**Environment variables (prod-friendly):**

* `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`
* `SPRING_PROFILES_ACTIVE` (e.g., `prod`)
* `JWT_SECRET`

---

## 🐳 Run with Docker

`docker-compose.yml` (backend only):

```yaml
version: "3.9"
services:
  db:
    image: postgres:16
    environment:
      POSTGRES_USER: app
      POSTGRES_PASSWORD: app
      POSTGRES_DB: tracker
    ports: ["5432:5432"]
    volumes:
      - pgdata:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U app -d tracker"]
      interval: 10s
      timeout: 5s
      retries: 5

  api:
    build: .
    depends_on:
      db:
        condition: service_healthy
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/tracker
      SPRING_DATASOURCE_USERNAME: app
      SPRING_DATASOURCE_PASSWORD: app
      JWT_SECRET: change-me
      SPRING_PROFILES_ACTIVE: prod
    ports: ["8080:8080"]

volumes:
  pgdata: {}
```

**Build & Run:**

```bash
# from backend/
docker compose up --build
# API: http://localhost:8080
# Swagger: http://localhost:8080/swagger-ui.html
```

---

## 👩‍💻 Local Development

**Prerequisites**

* Java 23+, Maven 3.9+
* Docker (optional but recommended for PostgreSQL)

**Start DB via Docker (dev):**

```bash
docker run --name tracker-db -e POSTGRES_USER=app -e POSTGRES_PASSWORD=app \
  -e POSTGRES_DB=tracker -p 5432:5432 -d postgres:16
```

**Run the app:**

```bash
mvn spring-boot:run
```

**Package:**

```bash
mvn -DskipTests package
```

---

## 🧪 Testing

* Unit tests: JUnit 5 + Mockito
* Integration tests: `@SpringBootTest` + **Testcontainers** (PostgreSQL)

Run:

```bash
mvn -B -ntp verify
```

---

## 📝 POM Snippets

Key deps:

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
  </dependency>

  <!-- Security & JWT (choose your JWT lib) -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>

  <!-- MapStruct -->
  <dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.5.5.Final</version>
  </dependency>
  <dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>1.5.5.Final</version>
    <scope>provided</scope>
  </dependency>

  <!-- Flyway -->
  <dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
  </dependency>

  <!-- OpenAPI / Swagger -->
  <dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.6.0</version>
  </dependency>

  <!-- Tests -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>postgresql</artifactId>
    <scope>test</scope>
  </dependency>
</dependencies>
```

---

## 🔐 Security Notes

* Passwords hashed with **BCrypt**.
* Short-lived access tokens; refresh tokens for renewal.
* CORS configured (e.g., allow `http://localhost:5173` during dev).
* Consider rate limiting and proper exception handling.

---

## ✅ Definition of Done (per feature)

* Flyway migration
* Entity + Repository + Service + Controller
* DTOs + MapStruct mappers
* Validation (Jakarta)
* Tests (unit + integration)
* Swagger updated
* Changelog entry (optional)

---

## 📄 License

MIT © 2025
