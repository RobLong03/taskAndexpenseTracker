package com.roberto.main.models.tasks;

import com.roberto.main.models.anagraficas.TaskProfile;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.TimeZoneColumn;

import java.time.LocalDateTime;


@Entity
@Table(name="task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "task_job_id")
    private TaskJob TaskJob;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name="description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;


    @Column(name="progress",length = Byte.MAX_VALUE)
    private Byte progress;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;


    @Column(name = "due_date", nullable = false,
            columnDefinition = "TIMESTAMP")
    private LocalDateTime due_date;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_tag_id")
    private TaskTag taskTag;

}
