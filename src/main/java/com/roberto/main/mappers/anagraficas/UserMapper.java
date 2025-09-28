package com.roberto.main.mappers.anagraficas;

import com.roberto.main.dtos.anagraficas.UserDto;

import com.roberto.main.models.anagraficas.User;
import com.roberto.main.requests.anagraficas.UserRequest;


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
        dto.setCreatedAt(user.getCreatedAt());
        dto.setLastUpdatedOn(user.getLastUpdatedOn());



        dto.setFinancialProfile(
                ExpenseProfileMapper.toUserDto(user.getFinancialProfile())
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
        dto.setCreatedAt(user.getCreatedAt());
        dto.setLastUpdatedOn(user.getLastUpdatedOn());

        dto.setFinancialProfile(
                ExpenseProfileMapper.toUserDtoComplete(user.getFinancialProfile())
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
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setLastUpdatedOn(dto.getLastUpdatedOn());



        entity.setFinancialProfile(
                ExpenseProfileMapper.toExpenseProfileEntity(dto.getFinancialProfile())
        );

        return entity;
    }

    public static User toUserEntity(UserRequest userRequest){
        if (userRequest == null) return null;
        User user = new User();
        user.setId(userRequest.getId());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        user.setActive(userRequest.isActive());
        user.setCreatedAt(userRequest.getCreatedAt());
        user.setLastUpdatedOn(userRequest.getLastUpdatedOn());

        user.setFinancialProfile(
         ExpenseProfileMapper.toExpenseProfileEntity(userRequest.getFinancialProfileRequest()));

        return user;

    }
}


