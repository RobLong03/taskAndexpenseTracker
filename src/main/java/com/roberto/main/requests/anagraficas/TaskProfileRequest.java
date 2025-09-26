package com.roberto.main.requests.anagraficas;

import com.roberto.main.models.anagraficas.User;
import com.roberto.main.models.tasks.TaskJob;
import com.roberto.main.requests.tasks.TaskJobRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskProfileRequest {




    private UserRequest user;


    private String profileType;


    private List<TaskJobRequest> TaskJobs;

}
