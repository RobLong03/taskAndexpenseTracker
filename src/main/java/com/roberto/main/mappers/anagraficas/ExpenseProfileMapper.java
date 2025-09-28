package com.roberto.main.mappers.anagraficas;

import com.roberto.main.dtos.anagraficas.ExpenseProfileDto;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.requests.anagraficas.ExpenseProfileRequest;

public class ExpenseProfileMapper {

    public static ExpenseProfileDto toUserDto(ExpenseProfile entity) {
        if (entity == null) return null;

        ExpenseProfileDto dto = new ExpenseProfileDto();
        dto.setId(entity.getId());
        dto.setBudget(entity.getBudget());
        dto.setDescription(entity.getDescription());
        dto.setActiveAmount(entity.getActiveAmount());
        dto.setPassiveAmount(entity.getPassiveAmount());
        return dto;
    }

    public static ExpenseProfileDto toUserDtoComplete(ExpenseProfile entity) {
        if (entity == null) return null;

        ExpenseProfileDto dto = new ExpenseProfileDto();
        dto.setId(entity.getId());
        dto.setBudget(entity.getBudget());
        dto.setDescription(entity.getDescription());
        dto.setActiveAmount(entity.getActiveAmount());
        dto.setPassiveAmount(entity.getPassiveAmount());



        return dto;
    }

    public static ExpenseProfile toExpenseProfileEntity(ExpenseProfileDto dto) {
        if (dto == null) return null;

        ExpenseProfile entity = new ExpenseProfile();
        entity.setId(dto.getId());
        entity.setBudget(dto.getBudget());
        entity.setDescription(dto.getDescription());
        entity.setActiveAmount(dto.getActiveAmount());
        entity.setPassiveAmount(dto.getPassiveAmount());
        return entity;
    }
    public static ExpenseProfile toExpenseProfileEntity(ExpenseProfileRequest request) {
        if (request == null) return null;

        ExpenseProfile entity = new ExpenseProfile();
        entity.setId(request.getId());
        entity.setBudget(request.getBudget());
        entity.setDescription(request.getDescription());
        entity.setActiveAmount(request.getActiveAmount());
        entity.setPassiveAmount(request.getPassiveAmount());
        return entity;
    }
}
