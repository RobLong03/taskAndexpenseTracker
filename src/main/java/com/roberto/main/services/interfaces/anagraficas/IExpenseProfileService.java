package com.roberto.main.services.interfaces.anagraficas;

import com.roberto.main.dtos.anagraficas.ExpenseProfileDto;
import com.roberto.main.dtos.anagraficas.TaskProfileDto;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.requests.anagraficas.ExpenseProfileRequest;
import com.roberto.main.requests.anagraficas.TaskProfileRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IExpenseProfileService{

    public void SaveOrUpdateExpenseProfile(ExpenseProfileRequest expenseProfileRequest)throws Exception;

    public void DeleteExpenseProfile(ExpenseProfileRequest expenseProfileRequest)throws Exception;

    public Optional<ExpenseProfileDto> GetExpenseProfileById(Integer Id)throws Exception;

    public List<ExpenseProfileDto> GetAllExpenseProfiles()throws Exception;
}
