package com.roberto.main.mappers.anagraficas;

import com.roberto.main.dtos.anagraficas.TaskProfileDto;
import com.roberto.main.models.anagraficas.TaskProfile;

public class TaskProfileMapper {

    public  static TaskProfileDto toTaskTaskProfileDto(TaskProfile profile) {
        TaskProfileDto profileDto = new TaskProfileDto();
        profileDto.setId(profile.getId());
        profileDto.setUserDto(UserMapper.toUserDto(profile.getUser()));
        profileDto.setProfileType(profile.getProfileType());
       // profileDto.setTaskJobs(TaskJobMapper.toTaskTaskProfileDto());



        return  profileDto;
    }

    public  static TaskProfile toEntityTaskyProfile(TaskProfileDto profiledto) {
        TaskProfile profile = new TaskProfile();
        profile.setId(profiledto.getId());
        profile.setProfileType(profiledto.getProfileType());
        profile.setUser(UserMapper.toUserEntity(profiledto.getUserDto()));



        // profileDto.setTaskJobs(TaskJobMapper.toTaskTaskProfileDto());



        return  profile;
    }
}
