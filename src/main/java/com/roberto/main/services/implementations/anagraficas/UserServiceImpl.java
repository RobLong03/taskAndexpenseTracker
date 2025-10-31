package com.roberto.main.services.implementations.anagraficas;


import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.mappers.anagraficas.UserMapper;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.repositories.anagraficas.UserRepository;
import com.roberto.main.requests.anagraficas.UserRequest;
import com.roberto.main.services.interfaces.anagraficas.IUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//it serves to have the constructor injector without doing or making by hand the constructor
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private Logger log;


    @Override
    public void SaveOrUpdateUser(UserRequest userRequest) throws Exception {
        if (userRequest == null) {
        log.error("{} this is null", userRequest);
        throw new Exception("Task Profile Request is null");
    }
        log.info("Saving user");
        User userSave;
        if (userRequest.getId() != null) {
            Optional<User> existingUser = userRepository.getUserById((userRequest.getId()));
            if (existingUser.isPresent()) {
                userSave = existingUser.get();
                // update fields from request into entity
                log.info("{} userRequest ;userSave:{}", userRequest, userSave);
                userMapper.updateUserFromRequest(userRequest, userSave);
            } else {
                // if id given but not found, decide if you want to throw exception or insert
                throw new Exception("User not found with id: " + userRequest.getId());
            }
        } else {
            userSave = userMapper.toUser(userRequest);
        }

         userRepository.save(userSave);

    }

    @Override
    public void DeleteUser(UserRequest userRequest) throws Exception {

        if (userRequest == null) return;
        Optional<User> existingUser = userRepository.getUserById((userRequest.getId()));
        if (existingUser.isPresent()) {
            userRepository.deleteById(userRequest.getId());
        }else {
            throw new Exception("User not found with id: " + userRequest.getId());
        }

    }

    @Override
    public Optional<UserDto> GetUserById(Integer Id) throws Exception {
         return Optional.ofNullable(userMapper.userToUserDto(userRepository.getUserById(Id).
                 orElseThrow(() -> new Exception("User not found with id: " + Id))));
    }

    @Override
    public List<UserDto> GetAllUsers() throws Exception {
        return userMapper.toUserDtos(userRepository.findAll()) ;
    }
}
