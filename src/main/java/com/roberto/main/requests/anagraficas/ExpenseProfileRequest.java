package com.roberto.main.requests.anagraficas;

import com.roberto.main.requests.expenses.ExpenseJobRequest;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseProfileRequest {


    private Integer id;

    private UserRequest user;


    private String description;

    private BigDecimal activeAmount;

    private BigDecimal passiveAmount;

    private BigDecimal balance;

    private List<ExpenseJobRequest> expenseJobRequests;

    private BigDecimal budget;


}
