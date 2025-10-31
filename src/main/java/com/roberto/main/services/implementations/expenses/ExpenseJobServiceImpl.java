package com.roberto.main.services.implementations.expenses;


import com.roberto.main.dtos.expenses.ExpenseJobDto;
import com.roberto.main.mappers.expenses.ExpenseJobMapper;
import com.roberto.main.models.anagraficas.TaskProfile;
import com.roberto.main.models.expenses.ExpenseJob;
import com.roberto.main.repositories.expenses.ExpenseCategoryRepository;
import com.roberto.main.repositories.expenses.ExpenseJobRepository;
import com.roberto.main.requests.expenses.ExpenseJobRequest;
import com.roberto.main.services.interfaces.expenses.IExpenseJobService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseJobServiceImpl implements IExpenseJobService {

    private final ExpenseJobRepository expenseJobRepository;
    private final ExpenseJobMapper mapper;

    private Logger log;

    @Override
    public void SaveOrUpdateExpenseJob(ExpenseJobRequest expenseJobRequest) throws Exception {
        if (expenseJobRequest == null) {
            log.error("{} this is null",expenseJobRequest);
            throw new Exception("ExpenseJobRequest is null");
        }
        ExpenseJob expenseJob;
        if (expenseJobRequest.getId()!=null) {
            Optional<ExpenseJob> existing = expenseJobRepository.findById((expenseJobRequest.getId()));
            if (existing.isPresent()) {
                expenseJob = existing.get();
                mapper.updateExpenseJobFromRequest(expenseJobRequest,expenseJob);
            }else{
                // if id given but not found, decide if you want to throw exception or insert
                throw new Exception("ExpenseJobRequest not found with id: " + expenseJobRequest.getId());
            }
        }else{
            expenseJob=mapper.toExpenseJob(expenseJobRequest);
        }
        expenseJobRepository.save(expenseJob);
    }

    @Override
    public void DeleteExpenseJob(ExpenseJobRequest expenseJobRequest) throws Exception {
        if (expenseJobRequest == null)
            throw new Exception("Task Profile Request is null");
        Optional<ExpenseJob> existing = expenseJobRepository.findById(expenseJobRequest.getId());
        if (existing.isPresent()) {
            expenseJobRepository.deleteExpenseJobById((expenseJobRequest.getId()));
        }else {
            throw new Exception("User not found with id: " + expenseJobRequest.getId());
        }
    }

    @Override
    public Optional<ExpenseJobDto> GetExpenseJobById(Integer Id) throws Exception {
        return Optional.of(mapper.toExpenseJobDto(expenseJobRepository.findById(Id)
                .orElseThrow(() -> new Exception("User not found with id: " + Id))));
    }

    @Override
    public List<ExpenseJobDto> GetAllExpenseJobs() throws Exception {
        return mapper.toExpenseJobDtos(expenseJobRepository.findAll()) ;
    }
}
