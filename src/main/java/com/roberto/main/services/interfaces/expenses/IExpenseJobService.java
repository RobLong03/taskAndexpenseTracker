package com.roberto.main.services.interfaces.expenses;

import com.roberto.main.dtos.expenses.ExpenseDto;
import com.roberto.main.dtos.expenses.ExpenseJobDto;
import com.roberto.main.models.expenses.ExpenseJob;
import com.roberto.main.requests.expenses.ExpenseJobRequest;
import com.roberto.main.requests.expenses.ExpenseRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IExpenseJobService  {


    public Integer SaveOrUpdateExpenseJob(ExpenseJobRequest expenseJobRequest)throws Exception;

    public void DeleteExpenseJob(ExpenseJobRequest expenseJobRequest)throws Exception;

    public Optional<ExpenseJobDto> GetExpenseJobById(Integer Id)throws Exception;

    public List<ExpenseJobDto> GetAllExpenseJobs()throws Exception;
}
