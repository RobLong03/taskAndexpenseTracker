package com.roberto.main.services.implementations.anagraficas;


import com.roberto.main.dtos.anagraficas.TaskProfileDto;
import com.roberto.main.mappers.anagraficas.TaskProfileMapper;
import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.anagraficas.TaskProfile;
import com.roberto.main.repositories.anagraficas.TaskProfileRepository;
import com.roberto.main.requests.anagraficas.TaskProfileRequest;
import com.roberto.main.services.interfaces.anagraficas.ITaskProfileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskProfileServiceImpl implements ITaskProfileService {

    private final TaskProfileRepository taskProfileRepository;
    private final TaskProfileMapper taskProfileMapper;

    private Logger log;

    @Override
    public void SaveOrUpdateTaskProfile(TaskProfileRequest taskProfileRequest) throws Exception {
        if (taskProfileRequest == null) {
            log.error("{} this is null",taskProfileRequest);
            throw new Exception("Task Profile Request is null");
        }
        TaskProfile taskProfile;
        if (taskProfileRequest.getId()!=null) {
            Optional<TaskProfile> optionalTaskProfile = taskProfileRepository.findById(taskProfileRequest.getId());
            if (optionalTaskProfile.isPresent()) {
                taskProfile = optionalTaskProfile.get();
                taskProfileMapper.updateTaskProfile(taskProfileRequest,taskProfile);
            }else{
                // if id given but not found, decide if you want to throw exception or insert
                throw new Exception("TaskProfileRequest not found with id: " + taskProfileRequest.getId());
            }
        }else{
            taskProfile=taskProfileMapper.toTaskProfile(taskProfileRequest);
        }
        taskProfileRepository.save(taskProfile);
    }

    @Override
    public void DeleteTaskProfile(TaskProfileRequest taskProfileRequest) throws Exception {
        if (taskProfileRequest == null)
            throw new Exception("Task Profile Request is null");
        Optional<TaskProfile> existing = taskProfileRepository.getExpenseProfileById(taskProfileRequest.getId());
        if (existing.isPresent()) {
            taskProfileRepository.deleteById(taskProfileRequest.getId());
        }else {
            throw new Exception("User not found with id: " + taskProfileRequest.getId());
        }
    }

    @Override
    public Optional<TaskProfileDto> GetTaskProfileById(Integer Id) throws Exception {
         return Optional.of(taskProfileMapper.toTaskProfileDto(taskProfileRepository.getExpenseProfileById(Id).
                 orElseThrow(() -> new Exception("User not found with id: " + Id))));
    }

    @Override
    public List<TaskProfileDto> GetAllTaskProfiles() throws Exception {
        return taskProfileMapper.toTaskProfileDtos(taskProfileRepository.findAll()) ;
    }
}
