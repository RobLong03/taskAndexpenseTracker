package com.roberto.main.services.interfaces.tasks;

import com.roberto.main.dtos.tasks.TaskDto;
import com.roberto.main.dtos.tasks.TaskTagDto;
import com.roberto.main.models.tasks.TaskTag;
import com.roberto.main.requests.tasks.TaskRequest;
import com.roberto.main.requests.tasks.TaskTagRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITaskTagService  {

    public void SaveOrUpdateTaskTag(TaskTagRequest taskTagRequest)throws Exception;

    //to add a method that delete by ID
    public void DeleteTaskTag(TaskTagRequest taskTagRequest)throws Exception;

    public Optional<TaskTagDto> GetTaskTagById(Integer Id)throws Exception;

    public List<TaskTagDto> GetAllTaskTags()throws Exception;
}
