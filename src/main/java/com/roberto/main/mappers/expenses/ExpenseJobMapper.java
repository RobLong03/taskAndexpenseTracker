package com.roberto.main.mappers.expenses;

import com.roberto.main.dtos.expenses.ExpenseJobDto;
import com.roberto.main.mappers.anagraficas.ExpenseProfileMapper;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.expenses.Expense;
import com.roberto.main.models.expenses.ExpenseJob;

public class ExpenseJobMapper {

    public  static ExpenseJobDto toExpenseJobDto(ExpenseJob expensejob) {

        ExpenseJobDto expensejobDto = new ExpenseJobDto();
        expensejobDto.setId(expensejob.getId());
        expensejobDto.setMonthlyBudget(expensejob.getMonthlyBudget());
        expensejobDto.setExpenseProfileDto(
                ExpenseProfileMapper.toDto(expensejob.getExpenseprofile()));
        return expensejobDto;
    }

    public  static ExpenseJob toExpenseJobEntity(ExpenseJobDto expenseJobDto) {

        ExpenseJob expensejob = new ExpenseJob();
        expensejob.setId(expenseJobDto.getId());
        expensejob.setMonthlyBudget(expenseJobDto.getMonthlyBudget());
        expensejob.setExpenseprofile(
                ExpenseProfileMapper.toEntity(expenseJobDto.getExpenseProfileDto()));
        return expensejob;
    }
}
