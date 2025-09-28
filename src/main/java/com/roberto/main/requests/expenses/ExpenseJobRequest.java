package com.roberto.main.requests.expenses;


import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.requests.anagraficas.ExpenseProfileRequest;
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
public class ExpenseJobRequest {


    private Integer Id;
    // Relationship to ExpenseProfile

    private ExpenseProfileRequest expenseprofile;


    private BigDecimal monthlyBudget;


}
