package com.roberto.main.dtos.tasks;


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
public class TaskTagDto {


    private Integer Id;


    private String description;

    private List<TaskDto> tasksDtos;

}
