package com.roberto.main.services.interfaces.anagraficas;

import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.requests.anagraficas.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserService  {

    public Integer SaveOrUpdateUser(UserRequest userRequest)throws Exception;
    //to add a method that delete by ID
    public void DeleteUser(UserRequest userRequest)throws Exception;

    public Optional<UserDto>GetUserById(Integer Id)throws Exception;

    public List<UserDto> GetAllUsers()throws Exception;


}
