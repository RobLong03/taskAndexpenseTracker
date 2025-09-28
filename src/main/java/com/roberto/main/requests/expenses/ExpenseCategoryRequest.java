package com.roberto.main.requests.expenses;

import jakarta.persistence.Column;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseCategoryRequest {


    private Integer Id;

    private String description;
}
