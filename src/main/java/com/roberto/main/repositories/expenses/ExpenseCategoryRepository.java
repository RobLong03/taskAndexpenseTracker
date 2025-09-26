package com.roberto.main.repositories.expenses;

import com.roberto.main.models.expenses.ExpenseCategory;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseCategoryRepository extends CrudRepository<ExpenseCategory, Integer> {
}
