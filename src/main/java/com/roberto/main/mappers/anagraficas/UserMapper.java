package com.roberto.main.mappers.anagraficas;

import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.dtos.expenses.ExpenseProfileDto;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.anagraficas.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setActive(user.isActive());

        dto.setFinancialProfile(
                ExpenseProfileMapper.toDto(user.getFinancialProfile())
        );

        return dto;
    }

    public static UserDto toUserDtoComplete(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setActive(user.isActive());

        dto.setFinancialProfile(
                ExpenseProfileMapper.toDtoComplete(user.getFinancialProfile())
        );


        return dto;
    }


    public static User toUserEntity(UserDto dto) {
        if (dto == null) return null;

        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        entity.setActive(dto.isActive());


        entity.setFinancialProfile(
                ExpenseProfileMapper.toEntity(dto.getFinancialProfile())
        );

        return entity;
    }
}


