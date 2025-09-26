package com.roberto.main.models.anagraficas;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(nullable = false,name="username")
	private String username;

	@Column(nullable = false,name = "name")
	private String name;
	
	@Column(nullable = false,name = "surname")
	private String surname;
	
	@Email
	private String email;
	
	@Column(nullable = false,name = "password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@Column(nullable = true,name = "active_account")
	private boolean active;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false,
	        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "last_update_on", nullable = false, updatable = false,
	        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdatedOn;

	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	private ExpenseProfile financialProfile;


}
