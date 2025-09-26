package com.roberto.main.mappers.tasks;

import com.roberto.main.dtos.tasks.TaskDto;
import com.roberto.main.models.tasks.Task;

public class TaskMapper {

    public static TaskDto toTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();

        taskDto.setId(task.getId());
        taskDto.setPriority(task.getPriority());
        taskDto.setDescription(task.getDescription());
        taskDto.setDue_date(task.getDue_date());
        taskDto.setProgress(task.getProgress());
        taskDto.setPriority(task.getPriority());
        taskDto.setTaskJobDto();



    }

    public static Task toEntityTask(TaskDto taskDto) {
        Task task = new Task();

        taskDto.setId(taskDto.getId());
        task.setPriority(taskDto.getPriority());
        task.setDescription(taskDto.getDescription());
        task.setDue_date(taskDto.getDue_date());
        task.setProgress(taskDto.getProgress());
        task.setPriority(taskDto.getPriority());

        task.setTaskJob(TaskJobMapper.toEntityTaskTag(taskDto.getTaskTagDto()));

        return task;



    }
}
