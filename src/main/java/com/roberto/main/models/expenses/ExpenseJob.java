package com.roberto.main.models.expenses;

import java.math.BigDecimal;
import java.util.Locale;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Currency;

import com.roberto.main.models.anagraficas.ExpenseProfile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="expense_job_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseJob  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	 // Relationship to ExpenseProfile
    @ManyToOne(optional = false)
    @JoinColumn(name = "profile_id")
    private ExpenseProfile expenseprofile;
	
	@Column(name="monthly_budget")
	@Currency(value = { "EUR" ,"USD"})
	private BigDecimal monthlyBudget;
	
	

}
