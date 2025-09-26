package com.roberto.main.models.anagraficas;

import java.math.BigDecimal;
import java.util.List;

import com.roberto.main.models.expenses.ExpenseJob;
import com.roberto.main.models.tasks.TaskJob;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="task_user_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskProfile {

 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;


    @Column(name = "description")
    private String profileType;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "Id"
    )
    private List<TaskJob> TaskJobs;

    //settings maybe inserted to be used to adjust logic





//	private List<Category> preferredCategories;
	
}
