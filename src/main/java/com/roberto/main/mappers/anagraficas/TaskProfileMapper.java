package com.roberto.main.mappers.anagraficas;

import com.roberto.main.dtos.anagraficas.TaskProfileDto;
import com.roberto.main.mappers.tasks.TaskJobMapper;
import com.roberto.main.models.anagraficas.TaskProfile;

import java.util.stream.Collectors;

public class TaskProfileMapper {

    public  static TaskProfileDto toTaskTaskProfileDto(TaskProfile profile) {
        if (profile == null) return  null;

        TaskProfileDto profileDto = new TaskProfileDto();
        profileDto.setId(profile.getId());
        profileDto.setUserDto(UserMapper.toUserDto(profile.getUser()));
        profileDto.setProfileType(profile.getProfileType());

        if(!profile.getTaskJobs().isEmpty()) profileDto.setTaskJobsDtos(profile.getTaskJobs().stream().map(TaskJobMapper::toTaskTagDto).collect(Collectors.toList()));
       // profileDto.setTaskJobs(TaskJobMapper.toTaskTaskProfileDto());



        return  profileDto;
    }

    public  static TaskProfile toEntityTaskyProfile(TaskProfileDto profiledto) {
        if (profiledto == null) return null;

        TaskProfile profile = new TaskProfile();
        profile.setId(profiledto.getId());
        profile.setProfileType(profiledto.getProfileType());
        profile.setUser(UserMapper.toUserEntity(profiledto.getUserDto()));


        if(!profiledto.getTaskJobsDtos().isEmpty()) profile.setTaskJobs(profiledto.getTaskJobsDtos().stream().map(TaskJobMapper::toEntityTaskTag).collect(Collectors.toList()));
        // profileDto.setTaskJobs(TaskJobMapper.toTaskTaskProfileDto());


        return  profile;
    }


}
