package com.roberto.main.dtos.anagraficas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roberto.main.dtos.expenses.ExpenseProfileDto;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.anagraficas.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@ToString(exclude = "password")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    private Integer Id;


    private String name;


    private String surname;


    private String email;


    @JsonIgnore
    private String password;


    private Role role;


    private boolean active;


    private ExpenseProfileDto financialProfile;


    //remember to manage the role as per se ExpenseProfileDTO
    //private ExpenseProfile financialProfile;

}
