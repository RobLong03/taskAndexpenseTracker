package com.roberto.main.repositories.expenses;

import com.roberto.main.models.anagraficas.User;
import com.roberto.main.models.expenses.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Integer> {
    Optional<ExpenseCategory> getExpenseCategoryById(Integer id);
}
