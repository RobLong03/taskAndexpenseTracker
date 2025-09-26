package com.roberto.main.dtos.expenses;

import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.expenses.ExpenseJob;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseProfileDto {

    private Integer Id;


    private UserDto userDto;

    private String description;


    private BigDecimal activeAmount;


    private BigDecimal passiveAmount;


    private BigDecimal balance;


    //Da aggiungere i dtos
    private List<ExpenseJobDto> ExpenseJobsDto;


    private BigDecimal budget;



}
