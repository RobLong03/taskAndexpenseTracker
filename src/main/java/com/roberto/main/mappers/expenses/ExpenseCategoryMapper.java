package com.roberto.main.mappers.expenses;

import com.roberto.main.dtos.expenses.ExpenseCategoryDto;
import com.roberto.main.models.expenses.ExpenseCategory;
import com.roberto.main.requests.expenses.ExpenseCategoryRequest;
import com.roberto.main.requests.expenses.ExpenseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {

})
public interface ExpenseCategoryMapper {



    ExpenseCategoryDto ExpenseCategoryToExpenseCategoryDto(ExpenseCategory expenseCategory);
    ExpenseCategory ExpenseCategoryDtoToExpenseCategory(ExpenseCategoryDto expenseCategoryDto);
    ExpenseRequest ExpenseCategoryToExpenseRequest(ExpenseCategory expenseCategory);
    ExpenseCategory ExpenseRequestDtoToExpenseCategory(ExpenseCategoryDto expenseCategoryDto);
    ExpenseCategory ExpenseCategoryRequestToExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest);


    //it doesn't suppose  to have an update , because indeed there are only two fields to be mapped


    /*

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
    }*/
}
