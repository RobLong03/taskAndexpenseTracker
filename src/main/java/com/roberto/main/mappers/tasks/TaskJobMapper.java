package com.roberto.main.mappers.tasks;

import com.roberto.main.dtos.tasks.TaskDto;
import com.roberto.main.dtos.tasks.TaskJobDto;

import com.roberto.main.mappers.anagraficas.TaskProfileMapper;
import com.roberto.main.models.anagraficas.TaskProfile;
import com.roberto.main.models.tasks.Task;
import com.roberto.main.models.tasks.TaskJob;

import java.util.ArrayList;
import java.util.List;


public class TaskJobMapper {

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
}
