package com.roberto.main.repositories.expenses;

import com.roberto.main.models.expenses.ExpenseJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseJobRepository extends JpaRepository<ExpenseJob, Long> {

}
