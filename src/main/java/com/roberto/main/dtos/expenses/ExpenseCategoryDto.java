package com.roberto.main.dtos.expenses;

import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.expenses.ExpenseJob;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseCategoryDto{

    private Integer id;

    private String description;

}
