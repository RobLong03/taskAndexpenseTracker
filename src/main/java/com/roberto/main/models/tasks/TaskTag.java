package com.roberto.main.models.tasks;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="task_tag")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "Id")
    private List<Task> tasks;
}
