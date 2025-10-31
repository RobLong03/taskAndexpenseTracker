package com.roberto.main.services.implementations.tasks;

import com.roberto.main.dtos.tasks.TaskDto;
import com.roberto.main.dtos.tasks.TaskJobDto;
import com.roberto.main.mappers.tasks.TaskJobMapper;
import com.roberto.main.mappers.tasks.TaskMapper;
import com.roberto.main.models.expenses.ExpenseJob;
import com.roberto.main.models.tasks.Task;
import com.roberto.main.models.tasks.TaskJob;
import com.roberto.main.repositories.tasks.TaskJobRepository;
import com.roberto.main.repositories.tasks.TaskRepository;
import com.roberto.main.requests.tasks.TaskJobRequest;
import com.roberto.main.requests.tasks.TaskRequest;
import com.roberto.main.services.interfaces.tasks.ITaskJobService;
import com.roberto.main.services.interfaces.tasks.ITasksService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITasksService {


    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    private Logger logger;

    @Override
    public void SaveOrUpdateTask(TaskRequest taskRequest) throws Exception {
        if (taskRequest == null) {
            logger.error("{} this is null in SaveOrUpdateTask",taskRequest);
            throw new Exception("taskRequest is null");
        }
        Task task;
        if (taskRequest.getId()!=null) {
            Optional<Task> existing = taskRepository.findById((taskRequest.getId()));
            if (existing.isPresent()) {
                task = existing.get();
                taskMapper.updateTaskFromRequest(taskRequest,task);
            }else{
                // if id given but not found, decide if you want to throw exception or insert
                throw new Exception("TaskRequest not found with id: " + taskRequest.getId());
            }
        }else{
            task=taskMapper.toTask(taskRequest);
        }
        taskRepository.save(task);
    }

    @Override
    public void DeleteTask(TaskRequest taskRequest) throws Exception {
        if (taskRequest == null)
            throw new Exception("Task  Request is null");
        Optional<Task> existing = taskRepository.findById(taskRequest.getId());
        if (existing.isPresent()) {
            taskRepository.deleteById((taskRequest.getId()));
        }else {
            throw new Exception("taskRequest not found with id: " + taskRequest.getId());
        }
    }

    @Override
    public Optional<TaskDto> GetTaskById(Integer Id) throws Exception {
        return Optional.of(taskMapper.toTaskDto(taskRepository.findById(Id)
                .orElseThrow(() -> new Exception("Task not found with id: " + Id))));
    }

    @Override
    public List<TaskDto> GetAllTasks() throws Exception {
        return taskMapper.toTaskDtos(taskRepository.findAll()) ;
    }
}
