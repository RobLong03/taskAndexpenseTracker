package com.roberto.main.services.implementations.expenses;


import com.roberto.main.dtos.expenses.ExpenseCategoryDto;
import com.roberto.main.mappers.anagraficas.UserMapper;
import com.roberto.main.mappers.expenses.ExpenseCategoryMapper;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.models.expenses.ExpenseCategory;
import com.roberto.main.repositories.anagraficas.UserRepository;
import com.roberto.main.repositories.expenses.ExpenseCategoryRepository;
import com.roberto.main.requests.expenses.ExpenseCategoryRequest;
import com.roberto.main.services.interfaces.expenses.IExpenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseCategoryServiceImpl implements IExpenseCategoryService {

    private final ExpenseCategoryRepository repo;
    private final ExpenseCategoryMapper mapper;

    private   Logger log;

    @Override
    public void SaveOrUpdateExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest) throws Exception {
        if (expenseCategoryRequest == null) {
            log.error("{} this is null", expenseCategoryRequest);
            throw new Exception("ExpenseCategoryRequest  is null");
        }
        log.info("Saving expenseCategoryRequest");
        ExpenseCategory savedExpenseCategory;
        if (expenseCategoryRequest.getId() != null) {
            Optional<ExpenseCategory> existing = repo.getExpenseCategoryById((expenseCategoryRequest.getId()));
            if (existing.isPresent()) {
                savedExpenseCategory = existing.get();
                // update fields from request into entity
                log.info("{} userRequest ;userSave:{}", expenseCategoryRequest, savedExpenseCategory);
                mapper.updateExpenseCategoryFromRequest(expenseCategoryRequest, savedExpenseCategory);
            } else {
                // if id given but not found, decide if you want to throw exception or insert
                throw new Exception("ExpenseCategory not found with id: " + expenseCategoryRequest.getId());
            }
        } else {
            savedExpenseCategory = mapper.ExpenseCategoryRequestToExpenseCategory(expenseCategoryRequest);
        }

        repo.save(savedExpenseCategory);

    }

    @Override
    public void DeleteExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest) throws Exception {

        if (expenseCategoryRequest == null) return;
        Optional<ExpenseCategory> existing = repo.getExpenseCategoryById((expenseCategoryRequest.getId()));
        if (existing.isPresent()) {
            repo.deleteById(expenseCategoryRequest.getId());
        }else {
            throw new Exception("ExpenseCategory not found with id: " + expenseCategoryRequest.getId());
        }
    }

    @Override
    public Optional<ExpenseCategoryDto> GetExpenseCategoryById(Integer Id) throws Exception {
        return Optional.ofNullable(mapper.ExpenseCategoryToExpenseCategoryDto(repo.getExpenseCategoryById(Id).
                orElseThrow(() -> new Exception("ExpenseCategory not found with id: " + Id))));
    }

    @Override
    public List<ExpenseCategoryDto> GetAllExpenseCategories() throws Exception {
        return mapper.toExpenseCategoryDtos(repo.findAll());
    }
}
