package com.roberto.main.repositories.anagraficas;

import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.anagraficas.TaskProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskProfileRepository extends JpaRepository<TaskProfile, Integer> {

    Optional<TaskProfile> getExpenseProfileById(Integer id);
}
