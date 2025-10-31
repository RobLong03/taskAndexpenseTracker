package com.roberto.main.services.implementations.tasks;

import com.roberto.main.dtos.tasks.TaskTagDto;
import com.roberto.main.mappers.tasks.TaskMapper;
import com.roberto.main.mappers.tasks.TaskTagMapper;
import com.roberto.main.models.tasks.Task;
import com.roberto.main.models.tasks.TaskTag;
import com.roberto.main.repositories.tasks.TaskRepository;
import com.roberto.main.repositories.tasks.TaskTagRepository;
import com.roberto.main.requests.tasks.TaskTagRequest;
import com.roberto.main.services.interfaces.tasks.ITaskTagService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskTagServiceImpl implements ITaskTagService {

    private final TaskTagRepository tasktagRepository;
    private final TaskTagMapper tasktagMapper;

    private Logger logger;


    @Override
    public void SaveOrUpdateTaskTag(TaskTagRequest taskTagRequest) throws Exception {
        if (taskTagRequest == null) {
            logger.error("{} this is null in SaveOrUpdateTask",taskTagRequest);
            throw new Exception("TaskTagRequest is null");
        }
        TaskTag taskTag;
        if (taskTagRequest.getId()!=null) {
            Optional<TaskTag> existing = tasktagRepository.findById((taskTagRequest.getId()));
            if (existing.isPresent()) {
                taskTag = existing.get();
                tasktagMapper.updateUserFromRequest(taskTagRequest,taskTag);
            }else{
                // if id given but not found, decide if you want to throw exception or insert
                throw new Exception("TaskTagRequest not found with id: " + taskTagRequest.getId());
            }
        }else{
            taskTag=tasktagMapper.toTaskTag(taskTagRequest);
        }
        tasktagRepository.save(taskTag);
    }

    @Override
    public void DeleteTaskTag(TaskTagRequest taskTagRequest) throws Exception {
        if (taskTagRequest == null)
            throw new Exception("TaskTag Request is null");
        Optional<TaskTag> existing = tasktagRepository.findById(taskTagRequest.getId());
        if (existing.isPresent()) {
            tasktagRepository.deleteById((taskTagRequest.getId()));
        }else {
            throw new Exception("TaskTag Request not found with id: " + taskTagRequest.getId());
        }
    }

    @Override
    public Optional<TaskTagDto> GetTaskTagById(Integer Id) throws Exception {
        return Optional.of(tasktagMapper.toTaskTagDto(tasktagRepository.findById(Id)
                .orElseThrow(() -> new Exception("TaskTag not found with id: " + Id))));
    }

    @Override
    public List<TaskTagDto> GetAllTaskTags() throws Exception {
        return tasktagMapper.toTaskTagDtos(tasktagRepository.findAll()) ;
    }
}
