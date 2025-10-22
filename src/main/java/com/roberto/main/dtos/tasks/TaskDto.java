package com.roberto.main.dtos.tasks;

import com.roberto.main.models.tasks.Priority;
import com.roberto.main.models.tasks.TaskJob;
import com.roberto.main.models.tasks.TaskTag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {


    private Integer id;

    private TaskJobDto taskJobDto;


    private String title;


    private String description;


    private Priority priority;


    private Byte progress;


    private LocalDateTime created_at;

    private LocalDateTime due_date;


    private TaskTagDto taskTagDto;
}
