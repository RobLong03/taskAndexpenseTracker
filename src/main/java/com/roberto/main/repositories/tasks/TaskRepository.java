package com.roberto.main.repositories.tasks;

import com.roberto.main.models.tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
