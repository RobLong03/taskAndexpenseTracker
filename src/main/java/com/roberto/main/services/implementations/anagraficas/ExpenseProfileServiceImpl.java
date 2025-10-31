package com.roberto.main.services.implementations.anagraficas;


import com.roberto.main.dtos.anagraficas.ExpenseProfileDto;
import com.roberto.main.mappers.anagraficas.ExpenseProfileMapper;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.repositories.anagraficas.ExpenseProfileRepository;
import com.roberto.main.requests.anagraficas.ExpenseProfileRequest;
import com.roberto.main.services.interfaces.anagraficas.IExpenseProfileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseProfileServiceImpl implements IExpenseProfileService {

    private final ExpenseProfileRepository expenseProfileRepository;
    private final ExpenseProfileMapper expenseProfileMapper;

    private  Logger log;

    @Override
    public void SaveOrUpdateExpenseProfile(ExpenseProfileRequest expenseProfileRequest) throws Exception {
        if (expenseProfileRequest==null) {
            log.error("{} this is null",expenseProfileRequest);
            throw new Exception("ExpenseProfile  Request is null");
        }
        ExpenseProfile profile;
        if (expenseProfileRequest.getId()!=null) {
            Optional<ExpenseProfile> expenseProfile = expenseProfileRepository.findById(expenseProfileRequest.getId());
            if (expenseProfile.isPresent()) {
                profile = expenseProfile.get();
                expenseProfileMapper.updateExpenseProfile(expenseProfileRequest,profile);
                log.info("{} ExpenseProfile found : {}",expenseProfileRequest,profile);
            }else {
                // if id given but not found, decide if you want to throw exception or insert
                throw new Exception("ExpenseProfileRequest not found with id: " + expenseProfileRequest.getId());
            }
        }else {
            profile=expenseProfileMapper.toExpenseProfile(expenseProfileRequest);
        }

        expenseProfileRepository.save(profile);
    }

    @Override
    public void DeleteExpenseProfile(ExpenseProfileRequest expenseProfileRequest) throws Exception {

        if (expenseProfileRequest == null) return;
        Optional<ExpenseProfile> existing = expenseProfileRepository.getExpenseProfileById((expenseProfileRequest.getId()));
        if (existing.isPresent()) {
            expenseProfileRepository.deleteById(expenseProfileRequest.getId());
        }else {
            throw new Exception("User not found with id: " + expenseProfileRequest.getId());
        }
    }

    @Override
    public Optional<ExpenseProfileDto> GetExpenseProfileById(Integer Id) throws Exception {
        return Optional.ofNullable(expenseProfileMapper.toExpenseProfileDto(expenseProfileRepository.getExpenseProfileById(Id).
                orElseThrow(() -> new Exception("User not found with id: " + Id))));
    }

    @Override
    public List<ExpenseProfileDto> GetAllExpenseProfiles() throws Exception {
        return expenseProfileMapper.toExpenseProfileDtos(expenseProfileRepository.findAll()) ;
    }
}
