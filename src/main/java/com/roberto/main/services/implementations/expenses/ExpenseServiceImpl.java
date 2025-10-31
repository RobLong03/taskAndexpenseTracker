package com.roberto.main.services.implementations.expenses;


import com.roberto.main.dtos.expenses.ExpenseDto;
import com.roberto.main.mappers.expenses.ExpenseJobMapper;
import com.roberto.main.mappers.expenses.ExpenseMapper;
import com.roberto.main.models.expenses.Expense;
import com.roberto.main.models.expenses.ExpenseJob;
import com.roberto.main.repositories.expenses.ExpenseJobRepository;
import com.roberto.main.repositories.expenses.ExpenseRepository;
import com.roberto.main.requests.expenses.ExpenseRequest;
import com.roberto.main.services.interfaces.expenses.IExpenseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements IExpenseService {

    private ExpenseRepository repository;
    private ExpenseMapper expenseMapper;

    private Logger logger;

    @Override
    public void  SaveOrUpdateExpense(ExpenseRequest expenseRequest) throws Exception {
        if (expenseRequest == null) {
            logger.error("{} this is null",expenseRequest);
            throw new Exception("ExpenseRequest is null");
        }
        Expense expense;
        if (expenseRequest.getId()!=null) {
            Optional<Expense> existing = repository.findById((expenseRequest.getId()));
            if (existing.isPresent()) {
                expense = existing.get();
                expenseMapper.updateExpense(expenseRequest,expense);
            }else{
                // if id given but not found, decide if you want to throw exception or insert
                throw new Exception("Expense not found with id: " + expenseRequest.getId());
            }
        }else{
            expense=expenseMapper.toExpense(expenseRequest);
        }
        repository.save(expense);
    }

    @Override
    public void DeleteExpense(ExpenseRequest expenseRequest) throws Exception {
        if (expenseRequest == null)
            throw new Exception("Expense Request is null");
        Optional<Expense> existing = repository.findById(expenseRequest.getId());
        if (existing.isPresent()) {
            repository.deleteById((expenseRequest.getId()));
        }else {
            throw new Exception("User not found with id: " + expenseRequest.getId());
        }
    }

    @Override
    public Optional<ExpenseDto> GetExpenseById(Integer Id) throws Exception {
        return Optional.of(expenseMapper.toExpenseDto(repository.findById(Id)
                .orElseThrow(() -> new Exception("Expense not found with id: " + Id))));
    }

    @Override
    public List<ExpenseDto> GetAllExpenseCategories() throws Exception {
        return expenseMapper.toExpenseDtos(repository.findAll()) ;
    }
}
