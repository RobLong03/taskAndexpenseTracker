package com.roberto.main.dtos.expenses;

import com.roberto.main.models.expenses.ExpenseCategory;
import com.roberto.main.models.expenses.ExpenseJob;
import com.roberto.main.models.expenses.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseDto   {


    private Integer Id;

    //create dto
    private ExpenseJobDto expenseJobDto;


    private BigDecimal expense;

    //create dto
    private ExpenseCategory category;



    private String description;


    private LocalDateTime date_of_expense;


    private LocalDateTime updatedAt;

    private PaymentMethod payment_method;
}
