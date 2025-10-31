package com.roberto.main.repositories.anagraficas;

import com.roberto.main.models.anagraficas.ExpenseProfile;
import com.roberto.main.models.anagraficas.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpenseProfileRepository extends JpaRepository<ExpenseProfile,Integer> {

    Optional< ExpenseProfile> getExpenseProfileById(Integer id);

}
