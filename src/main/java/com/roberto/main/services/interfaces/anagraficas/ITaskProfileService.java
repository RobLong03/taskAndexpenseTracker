package com.roberto.main.services.interfaces.anagraficas;

import com.roberto.main.dtos.anagraficas.TaskProfileDto;
import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.requests.anagraficas.TaskProfileRequest;

import java.util.List;
import java.util.Optional;

public interface ITaskProfileService  {

    public void SaveOrUpdateTaskProfile(TaskProfileRequest taskProfileRequest)throws Exception;

    public void DeleteTaskProfile(TaskProfileRequest taskProfileRequest)throws Exception;

    public Optional<TaskProfileDto> GetTaskProfileById(Integer Id)throws Exception;

    public List<TaskProfileDto> GetAllTaskProfiles()throws Exception;
}
