package com.roberto.main.services.interfaces.expenses;

import com.roberto.main.dtos.expenses.ExpenseCategoryDto;
import com.roberto.main.dtos.expenses.ExpenseDto;
import com.roberto.main.models.expenses.Expense;
import com.roberto.main.requests.expenses.ExpenseCategoryRequest;
import com.roberto.main.requests.expenses.ExpenseRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IExpenseService  {

    public Integer SaveOrUpdateExpense(ExpenseRequest expenseRequest)throws Exception;

    public void DeleteExpense(ExpenseRequest expenseRequest)throws Exception;

    public Optional<ExpenseDto> GetExpenseById(Integer Id)throws Exception;

    public List<ExpenseDto> GetAllExpenseCategories()throws Exception;
}
