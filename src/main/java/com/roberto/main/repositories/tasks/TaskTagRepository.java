package com.roberto.main.repositories.tasks;

import com.roberto.main.models.tasks.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTagRepository extends JpaRepository<TaskTag, Integer> {
}
