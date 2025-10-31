package com.roberto.main.requests.tasks;

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
public class TaskTagRequest {


    private Integer id;

    private String description;

    private List<TaskRequest> tasks;
}
