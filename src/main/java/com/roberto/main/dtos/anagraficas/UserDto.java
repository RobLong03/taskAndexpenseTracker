package com.roberto.main.dtos.anagraficas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.anagraficas.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(exclude = "password")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    private Integer id;

    private String username;

    private String name;


    private String surname;


    private String email;


    @JsonIgnore
    private String password;


    private Role role;


    private boolean active;


    private ExpenseProfileDto financialProfile;



    private LocalDateTime createdAt;


    private LocalDateTime lastUpdatedOn;

    //remember to manage the role as per se ExpenseProfileDTO
    //private ExpenseProfile financialProfile;

}
