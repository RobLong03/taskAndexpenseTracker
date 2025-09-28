package com.roberto.main.mappers.expenses;

import com.roberto.main.dtos.expenses.ExpenseCategoryDto;
import com.roberto.main.models.expenses.ExpenseCategory;

public class ExpenseCategoryMapper {

    public static ExpenseCategoryDto toExpenseCategoryDto(ExpenseCategory expenseCategory) {
        ExpenseCategoryDto expenseCategoryDto = new ExpenseCategoryDto();
        expenseCategoryDto.setId(expenseCategory.getId());
        expenseCategoryDto.setDescription(expenseCategory.getDescription());
        return expenseCategoryDto;
    }

    public static ExpenseCategory toExpenseCategoryEntity(ExpenseCategoryDto expenseCategorydto) {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setId(expenseCategorydto.getId());
        expenseCategory.setDescription(expenseCategorydto.getDescription());
        return expenseCategory;
    }
}
