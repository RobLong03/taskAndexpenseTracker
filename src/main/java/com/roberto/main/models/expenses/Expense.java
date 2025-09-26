package com.roberto.main.models.expenses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.extern.java.Log;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "expense")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "expense_job_id", nullable = false)
    private ExpenseJob expenseJob;

    @Currency(value = {"EUR", "USD"})
    @Column(name = "expense")
    private BigDecimal expense;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private ExpenseCategory category;


    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    @Column(name = "date_of_expense", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime date_of_expense;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


    @Column(name="payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;
}
