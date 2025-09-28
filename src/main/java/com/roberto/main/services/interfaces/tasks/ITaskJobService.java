package com.roberto.main.services.interfaces.tasks;

import com.roberto.main.dtos.expenses.ExpenseDto;
import com.roberto.main.dtos.tasks.TaskJobDto;
import com.roberto.main.models.tasks.TaskJob;
import com.roberto.main.requests.expenses.ExpenseRequest;
import com.roberto.main.requests.tasks.TaskJobRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITaskJobService  {

    public Integer SaveOrUpdateTaskJob(TaskJobRequest taskJobRequest)throws Exception;

    //to add a method that delete by ID
    public void DeleteTaskJob(TaskJobRequest taskJobRequest)throws Exception;

    public Optional<TaskJobDto> GetTaskJobById(Integer Id)throws Exception;

    public List<TaskJobDto> GetAllTaskJobs()throws Exception;
}
