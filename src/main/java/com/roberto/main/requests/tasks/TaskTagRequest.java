package com.roberto.main.requests.tasks;

import com.roberto.main.models.tasks.Task;
import jakarta.persistence.*;

import java.util.List;

public class TaskTagRequest {


    private String description;

    private List<TaskRequest> tasks;
}
