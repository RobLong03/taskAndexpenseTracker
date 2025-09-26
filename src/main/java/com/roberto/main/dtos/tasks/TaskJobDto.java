package com.roberto.main.dtos.tasks;


import com.roberto.main.dtos.anagraficas.TaskProfileDto;
import com.roberto.main.models.anagraficas.TaskProfile;
import com.roberto.main.models.tasks.Task;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskJobDto {


    private Integer Id;


    private TaskProfileDto taskProfileDto;


    private List<TaskDto> tasksDtos;
}
