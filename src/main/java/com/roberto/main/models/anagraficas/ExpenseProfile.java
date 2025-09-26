package com.roberto.main.models.anagraficas;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.validator.constraints.Currency;

import com.roberto.main.models.expenses.Expense;
import com.roberto.main.models.expenses.ExpenseJob;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="expense_user_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseProfile {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	@Column(name = "description")
	private String description;

	@Currency(value = {"EUR","USED"})
	@Column(name = "active_amount")
	private BigDecimal activeAmount;

	@Currency(value = {"EUR","USED"})
	@Column(name = "passive_amount")
	private BigDecimal passiveAmount;

	@Currency(value = {"EUR","USED"})
	@Column(name = "balance")
	private BigDecimal balance;
	@OneToMany(
	        orphanRemoval = true,
	        cascade = CascadeType.ALL,
	        fetch = FetchType.EAGER,
	        mappedBy = "expenseprofile" 
	    )
	private List<ExpenseJob> ExpenseJobs;

	
	@Currency(value = { "EUR" ,"USD"})
	@Column(name="annual_expense_budget")
	private BigDecimal budget;

	//settings maybe inserted to be used to adjust logic

	
}
