package com.roberto.main.repositories.expenses;


import com.roberto.main.models.expenses.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
