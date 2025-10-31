package com.roberto.main.models.tasks;


import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.anagraficas.TaskProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Currency;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="task_job_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskJob {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relationship to User
    @ManyToOne(optional = false)
    @JoinColumn(name = "profile_id")
    private TaskProfile taskProfile;


    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "id"
    )
    private List<Task> tasks;


}
