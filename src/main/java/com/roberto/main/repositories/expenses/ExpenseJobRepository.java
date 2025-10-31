package com.roberto.main.repositories.expenses;

import com.roberto.main.models.anagraficas.TaskProfile;
import com.roberto.main.models.expenses.ExpenseJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExpenseJobRepository extends JpaRepository<ExpenseJob, Long> {

    Optional<ExpenseJob> findById(Integer id);

    void deleteExpenseJobById(Integer id);


}
