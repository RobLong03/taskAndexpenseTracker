package com.roberto.main.requests.anagraficas;

import com.roberto.main.models.anagraficas.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {


    private Integer id;

    private String username;

    private String name;


    private String surname;


    private String email;


    private String password;


    private Role role;


    private boolean active;


    private LocalDateTime createdAt;


    private LocalDateTime lastUpdatedOn;



    //setup a request
    private ExpenseProfileRequest financialProfileRequest;
}
