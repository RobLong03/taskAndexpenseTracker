package com.roberto.main.mappers.expenses;

import com.roberto.main.dtos.expenses.ExpenseDto;
import com.roberto.main.models.expenses.Expense;
import com.roberto.main.models.expenses.ExpenseJob;

public class ExpenseMapper {

    public static ExpenseDto toExpenseDTo(Expense expense) {

        if (expense == null)return null;
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(expense.getId());
        expenseDto.setDescription(expense.getDescription());
        expenseDto.setDate_of_expense(expense.getDate_of_expense());
        expenseDto.setPayment_method(expense.getPayment_method());
        expenseDto.setCategory(expense.getCategory());
        expenseDto.setExpense(expense.getExpense());
        expenseDto.setUpdatedAt(expense.getUpdatedAt());

         expenseDto.setExpenseJobDto(
                 ExpenseJobMapper.toExpenseJobDto(expense.getExpenseJob()));
        return expenseDto;

    }

    public static Expense toExpenseEntity(ExpenseDto expensedto) {

        if (expensedto == null)return null;
        Expense expense = new Expense();
        expense.setId(expensedto.getId());
        expense.setDescription(expensedto.getDescription());
        expense.setDate_of_expense(expensedto.getDate_of_expense());
        expense.setPayment_method(expensedto.getPayment_method());
        expense.setCategory(expensedto.getCategory());
        expense.setExpense(expensedto.getExpense());
        expense.setUpdatedAt(expensedto.getUpdatedAt());

        expense.setExpenseJob(
                ExpenseJobMapper.toExpenseJobEntity(expensedto.getExpenseJobDto()));

        return expense;

    }


}
