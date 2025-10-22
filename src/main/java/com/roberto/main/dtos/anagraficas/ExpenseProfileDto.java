package com.roberto.main.dtos.anagraficas;

import com.roberto.main.dtos.expenses.ExpenseJobDto;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.models.expenses.ExpenseJob;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Currency;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseProfileDto {


    private Integer id;


    private UserDto userDto;


    private String description;


    private BigDecimal activeAmount;


    private BigDecimal passiveAmount;


    private BigDecimal balance;

    private List<ExpenseJobDto> ExpenseJobsDtos;


    private BigDecimal budget;

}
