package com.roberto.main.dtos.expenses;


import com.roberto.main.dtos.anagraficas.ExpenseProfileDto;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Currency;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseJobDto {


    private Integer Id;

    // Relationship to ExpenseProfile

    private ExpenseProfileDto expenseProfileDto;

    private BigDecimal monthlyBudget;


}
