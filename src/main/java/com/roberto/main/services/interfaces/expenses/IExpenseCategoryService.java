package com.roberto.main.services.interfaces.expenses;

import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.dtos.expenses.ExpenseCategoryDto;
import com.roberto.main.models.expenses.ExpenseCategory;
import com.roberto.main.requests.anagraficas.UserRequest;
import com.roberto.main.requests.expenses.ExpenseCategoryRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IExpenseCategoryService {
    public Integer SaveOrUpdateExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest)throws Exception;

    public void DeleteExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest)throws Exception;

    public Optional<ExpenseCategoryDto> GetExpenseCategoryById(Integer Id)throws Exception;

    public List<ExpenseCategoryDto> GetAllExpenseCategories()throws Exception;


}
