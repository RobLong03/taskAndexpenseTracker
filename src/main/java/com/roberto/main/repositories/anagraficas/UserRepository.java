package com.roberto.main.repositories.anagraficas;

import com.roberto.main.models.anagraficas.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
