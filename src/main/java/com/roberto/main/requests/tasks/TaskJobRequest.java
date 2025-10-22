package com.roberto.main.requests.tasks;

import com.roberto.main.models.anagraficas.TaskProfile;
import com.roberto.main.models.tasks.Task;
import com.roberto.main.requests.anagraficas.TaskProfileRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskJobRequest {


    private Integer id;

    private TaskProfileRequest taskProfile;


    private List<TaskRequest> tasks;

}
