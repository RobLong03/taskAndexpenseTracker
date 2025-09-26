package com.roberto.main.repositories.tasks;

import com.roberto.main.models.tasks.TaskJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJobRepository extends JpaRepository<TaskJob, Integer> {
}
