package com.roberto.main.services.implementations.anagraficas;


import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.requests.anagraficas.UserRequest;
import com.roberto.main.services.interfaces.anagraficas.IUserService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private IUserService userService;
    //private Logger logger;

    UserServiceImpl(IUserService userService) {
        this.userService = userService;
    }


    @Override
    public Integer SaveOrUpdateUser(UserRequest userRequest) throws Exception {
        if (userRequest==null)return null;


        if (userRequest.getId()!=null){


        }

        return 0;
    }

    @Override
    public void DeleteUser(UserRequest userRequest) throws Exception {

    }

    @Override
    public Optional<UserDto> GetUserById(Integer Id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<UserDto> GetAllUsers() throws Exception {
        return List.of();
    }
}
