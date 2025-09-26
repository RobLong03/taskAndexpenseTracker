package com.roberto.main.mappers.anagraficas;

import com.roberto.main.dtos.expenses.ExpenseProfileDto;
import com.roberto.main.models.anagraficas.ExpenseProfile;

public class ExpenseProfileMapper {

    public static ExpenseProfileDto toDto(ExpenseProfile entity) {
        if (entity == null) return null;

        ExpenseProfileDto dto = new ExpenseProfileDto();
        dto.setId(entity.getId());
        dto.setBudget(entity.getBudget());
        dto.setDescription(entity.getDescription());
        dto.setActiveAmount(entity.getActiveAmount());
        dto.setPassiveAmount(entity.getPassiveAmount());
        return dto;
    }

    public static ExpenseProfileDto toDtoComplete(ExpenseProfile entity) {
        if (entity == null) return null;

        ExpenseProfileDto dto = new ExpenseProfileDto();
        dto.setId(entity.getId());
        dto.setBudget(entity.getBudget());
        dto.setDescription(entity.getDescription());
        dto.setActiveAmount(entity.getActiveAmount());
        dto.setPassiveAmount(entity.getPassiveAmount());



        return dto;
    }

    public static ExpenseProfile toEntity(ExpenseProfileDto dto) {
        if (dto == null) return null;

        ExpenseProfile entity = new ExpenseProfile();
        entity.setId(dto.getId());
        entity.setBudget(dto.getBudget());
        entity.setDescription(dto.getDescription());
        entity.setActiveAmount(dto.getActiveAmount());
        entity.setPassiveAmount(dto.getPassiveAmount());
        return entity;
    }
}
