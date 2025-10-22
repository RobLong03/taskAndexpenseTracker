package com.roberto.main.requests.expenses;

import com.roberto.main.models.expenses.ExpenseCategory;
import com.roberto.main.models.expenses.ExpenseJob;
import com.roberto.main.models.expenses.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Currency;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {

    private Integer id;

    private ExpenseJobRequest expenseJob;


    private BigDecimal expense;

    private ExpenseCategory category;

    private String description;

    private LocalDateTime date_of_expense;

    private LocalDateTime updatedAt;

    private PaymentMethod payment_method;
}
