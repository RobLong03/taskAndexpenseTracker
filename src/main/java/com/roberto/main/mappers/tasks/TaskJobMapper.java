package com.roberto.main.mappers.tasks;

import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.dtos.tasks.TaskDto;
import com.roberto.main.dtos.tasks.TaskJobDto;

import com.roberto.main.mappers.anagraficas.ExpenseProfileMapper;
import com.roberto.main.mappers.anagraficas.TaskProfileMapper;
import com.roberto.main.mappers.expenses.ExpenseJobMapper;
import com.roberto.main.models.anagraficas.TaskProfile;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.models.tasks.Task;
import com.roberto.main.models.tasks.TaskJob;
import com.roberto.main.requests.anagraficas.UserRequest;
import com.roberto.main.requests.tasks.TaskJobRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring",uses = {TaskMapper.class,  ExpenseProfileMapper.class})
public interface TaskJobMapper {

    // Request -> Entity
    @Mappings({
            @Mapping(target = "tasks", ignore = true) // avoid back-ref cycle
    })
    TaskJob toTaskJob(TaskJobRequest request);

    // Entity -> DTO
    @Mappings({
            @Mapping(target = "tasksDtos", ignore = true) // uncomment if exists
    })
    TaskJobDto toTaskJobDto(TaskJob job);

    // Request -> DTO

    //TO UNDERSTAND
    @Mappings({
            @Mapping(source = "taskProfileDto" , target = "taskProfile"),
            @Mapping(source = "tasksDtos", target = "tasks")
    })
    TaskJobRequest toTaskJobRequest(TaskJobDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTaskJobFromRequest(TaskJobRequest taskJobRequest, @MappingTarget TaskJob taskJob);

    @IterableMapping(qualifiedByName = "taskJobToTaskJobDtoNamed")
    List<TaskJobDto> toJobDtos(List<TaskJob> taskJobs);

    // Give the single mapping a name so the list method can reuse it
    @Named("taskJobToTaskJobDtoNamed")
    UserDto _userToUserDto(User user);
    /*
    public static TaskJobDto toTaskTagDto(TaskJob taskTag) {

        TaskJobDto taskTagDto = new TaskJobDto();
        List<TaskDto> taskDtos = new ArrayList<>();
        taskTagDto.setId(taskTag.getId());
        taskTagDto.setTaskProfileDto(TaskProfileMapper.toTaskTaskProfileDto(taskTag.getTaskProfile()));
        //TaskMapper.toTaskDto()
        if (!taskTag.getTasks().isEmpty()){
            taskTag.getTasks().forEach(task -> {taskDtos.add(TaskMapper.toTaskDto(task));});
            taskTagDto.setTasksDtos(taskDtos);
        }
       return  taskTagDto;



    }
    public  static TaskJob toEntityTaskTag(TaskJobDto taskJobDto) {


        TaskJob taskTag = new TaskJob();
        List<Task> tasks=null;
        taskTag.setId(taskJobDto.getId());


        if (!taskJobDto.getTasksDtos().isEmpty()) {
            tasks= new ArrayList<>();
            taskJobDto.getTasksDtos().forEach(taskDto->TaskMapper.toTaskDto(TaskMapper.toEntityTask(taskDto)));
            taskTag.setTasks(tasks);
        }
        if (taskJobDto.getTaskProfileDto() != null) {
            taskTag.setTaskProfile(TaskProfileMapper.toEntityTaskyProfile(taskJobDto.getTaskProfileDto()));
        }
      

        return  taskTag;

    }

     */
}
