package com.roberto.main.services.implementations.tasks;

import com.roberto.main.dtos.tasks.TaskJobDto;
import com.roberto.main.mappers.tasks.TaskJobMapper;
import com.roberto.main.models.expenses.Expense;
import com.roberto.main.models.tasks.TaskJob;
import com.roberto.main.repositories.tasks.TaskJobRepository;
import com.roberto.main.requests.tasks.TaskJobRequest;
import com.roberto.main.services.interfaces.tasks.ITaskJobService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskJobServiceImpl implements ITaskJobService {

    private final TaskJobRepository taskRepository;
    private final TaskJobMapper  taskJobMapper;

    private Logger logger;

    @Override
    public void SaveOrUpdateTaskJob(TaskJobRequest taskJobRequest) throws Exception {
        if (taskJobRequest == null) {
            logger.error("{} this is null in SaveOrUpdateTaskJob",taskJobRequest);
            throw new Exception("TaskJobRequest is null");
        }
        TaskJob taskJob;
        if (taskJobRequest.getId()!=null) {
            Optional<TaskJob> existing = taskRepository.findById((taskJobRequest.getId()));
            if (existing.isPresent()) {
                taskJob = existing.get();
                taskJobMapper.updateTaskJobFromRequest(taskJobRequest,taskJob);
            }else{
                // if id given but not found, decide if you want to throw exception or insert
                throw new Exception("TaskJobRequest not found with id: " + taskJobRequest.getId());
            }
        }else{
            taskJob=taskJobMapper.toTaskJob(taskJobRequest);
        }
        taskRepository.save(taskJob);
    }

    @Override
    public void DeleteTaskJob(TaskJobRequest taskJobRequest) throws Exception {

        if (taskJobRequest == null)
            throw new Exception("TaskJobRequest Request is null");
        Optional<TaskJob> existing = taskRepository.findById(taskJobRequest.getId());
        if (existing.isPresent()) {
            taskRepository.deleteById((taskJobRequest.getId()));
        }else {
            throw new Exception("TaskJob not found with id: " + taskJobRequest.getId());
        }
    }

    @Override
    public Optional<TaskJobDto> GetTaskJobById(Integer Id) throws Exception {
        return Optional.of(taskJobMapper.toTaskJobDto(taskRepository.findById(Id)
                .orElseThrow(() -> new Exception("TaskJob not found with id: " + Id))));
    }

    @Override
    public List<TaskJobDto> GetAllTaskJobs() throws Exception {
       return  taskJobMapper.toJobDtos(taskRepository.findAll()) ;
    }
}
