package com.roberto.main.services.interfaces.tasks;

import com.roberto.main.dtos.tasks.TaskDto;
import com.roberto.main.requests.tasks.TaskRequest;

import java.util.List;
import java.util.Optional;

public interface ITasksService  {

    public Integer SaveOrUpdateTask(TaskRequest taskRequest)throws Exception;

    //to add a method that delete by ID
    public void DeleteTask(TaskRequest taskRequest)throws Exception;

    public Optional<TaskDto> GetTaskById(Integer Id)throws Exception;

    public List<TaskDto> GetAllTasks()throws Exception;
}
