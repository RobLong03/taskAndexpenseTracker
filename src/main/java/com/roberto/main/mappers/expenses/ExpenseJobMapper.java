package com.roberto.main.mappers.expenses;

import com.roberto.main.dtos.expenses.ExpenseJobDto;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.models.expenses.ExpenseJob;
import com.roberto.main.requests.anagraficas.UserRequest;
import com.roberto.main.requests.expenses.ExpenseJobRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExpenseJobMapper {



    ExpenseJobDto toExpenseJobDto(ExpenseJob expenseJob);
    ExpenseJob fromExpenseJobDto(ExpenseJobDto expenseJobDto);
    ExpenseJob toExpenseJob(ExpenseJobRequest expenseJobRequest);
    ExpenseJobRequest toExpenseJobRequest(ExpenseJobDto expenseJobDto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(source = "expenseprofile",target = "expenseprofile"),
            @Mapping(source = "monthlyBudget",target = "monthlyBudget")
    })
    void updateExpenseJobFromRequest(ExpenseJobRequest expenseJobRequest, @MappingTarget ExpenseJob expenseJob);

    /*
    public  static ExpenseJobDto toExpenseJobDto(ExpenseJob expensejob) {

        ExpenseJobDto expensejobDto = new ExpenseJobDto();
        expensejobDto.setId(expensejob.getId());
        expensejobDto.setMonthlyBudget(expensejob.getMonthlyBudget());
        expensejobDto.setExpenseProfileDto(
                ExpenseProfileMapper.toUserDto(expensejob.getExpenseprofile()));
        return expensejobDto;
    }

    public  static ExpenseJob toExpenseJobEntity(ExpenseJobDto expenseJobDto) {

        ExpenseJob expensejob = new ExpenseJob();
        expensejob.setId(expenseJobDto.getId());
        expensejob.setMonthlyBudget(expenseJobDto.getMonthlyBudget());
        expensejob.setExpenseprofile(
                ExpenseProfileMapper.toExpenseProfileEntity(expenseJobDto.getExpenseProfileDto()));
        return expensejob;
    }

     */
}
