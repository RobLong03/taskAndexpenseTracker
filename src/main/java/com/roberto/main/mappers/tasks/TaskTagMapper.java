package com.roberto.main.mappers.tasks;

import com.roberto.main.dtos.tasks.TaskDto;
import com.roberto.main.dtos.tasks.TaskTagDto;
import com.roberto.main.models.tasks.Task;
import com.roberto.main.models.tasks.TaskTag;

import java.util.List;
import java.util.stream.Collectors;

public class TaskTagMapper {


    public static TaskTagDto toTaskTagDto(TaskTag taskTag) {

        if (taskTag == null) return null;
        TaskTagDto taskTagDto = new TaskTagDto();
        taskTagDto.setId(taskTag.getId());
        taskTagDto.setDescription(taskTag.getDescription());

        if (!taskTag.getTasks().isEmpty()) taskTagDto.setTasksDtos(taskTag.getTasks().stream().map(TaskMapper::toTaskDto).toList());



        return taskTagDto;

    }
    public  static TaskTag toEntityTaskTagDto(TaskTagDto taskTagDto) {

        if (taskTagDto == null) return null;
        TaskTag taskTag = new TaskTag();
        taskTag.setId(taskTagDto.getId());
        taskTag.setDescription(taskTagDto.getDescription());

        if (!taskTagDto.getTasksDtos().isEmpty()) taskTag.setTasks(taskTagDto.getTasksDtos().stream().map(TaskMapper::toEntityTask).toList());

        return taskTag;
    }

}
