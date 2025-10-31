package com.roberto.main.mappers.anagraficas;

import com.roberto.main.dtos.anagraficas.TaskProfileDto;
import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.dtos.tasks.TaskJobDto;
import com.roberto.main.mappers.tasks.TaskJobMapper;
import com.roberto.main.mappers.tasks.TaskMapper;
import com.roberto.main.mappers.tasks.TaskTagMapper;
import com.roberto.main.models.anagraficas.TaskProfile;
import com.roberto.main.models.tasks.TaskJob;
import com.roberto.main.requests.anagraficas.TaskProfileRequest;
import com.roberto.main.requests.anagraficas.UserRequest;
import com.roberto.main.requests.tasks.TaskJobRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        uses = { UserMapper.class, TaskJobMapper.class, TaskMapper.class, TaskTagMapper.class },
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface TaskProfileMapper {

    // -------- Entity -> DTO --------

    //recursive calling betweeenn many
    @Named("taskProfileToDto")
    @Mappings({
            @Mapping(target = "userDto",      source = "user"),
            @Mapping(target = "taskJobsDtos", source = "taskJobs")
            // DO NOT map taskProfileDto or tasksDtos unless they really exist on TaskProfileDto
    })
    TaskProfileDto toTaskProfileDto(TaskProfile taskProfile);

    @IterableMapping(qualifiedByName = "taskProfileToDto")
    @Mappings({
            @Mapping(target = "userDto", source = "user"),
            @Mapping(target = "taskJobsDtos", source = "taskJobs")
    })
    List<TaskProfileDto> toTaskProfileDtos(List<TaskProfile> taskProfiles);

    // -------- DTO -> Entity --------

    @Named("dtoToTaskProfile")
    @Mappings({
            @Mapping(target = "user", source = "userDto"),
            @Mapping(target = "taskJobs", source = "taskJobsDtos")
    })
    TaskProfile toTaskProfile(TaskProfileDto taskProfileDto);


    TaskProfile toTaskProfile(TaskProfileRequest taskProfileRequest);

    @IterableMapping(qualifiedByName = "dtoToTaskProfile")
    @Mappings({
            @Mapping(target = "user", source = "userDto"),
            @Mapping(target = "taskJobs", source = "taskJobsDtos")
    })
    List<TaskProfile> toTaskProfiles(List<TaskProfileDto> taskProfileDtos);

    // -------- Request -> DTO --------
    // userRequest -> user, taskJobRequests -> taskJobs
    @Mappings({
            @Mapping(target = "userDto", ignore = true),
            @Mapping(target = "taskJobsDtos" ,ignore = true)
    })
    TaskProfileDto toTaskProfileDto(TaskProfileRequest taskProfileRequest);

    // -------- DTO -> Request --------
    // user -> userRequest, taskJobs -> taskJobRequests
    @Mappings({
            @Mapping(target = "user", source = "userDto"),
            @Mapping(target = "taskJobs", source = "taskJobsDtos")
    })
    TaskProfileRequest toTaskProfileRequest(TaskProfileDto taskProfileDto);

    // -------- PATCH update (Request -> existing Entity) --------
    // Ignore nulls so we only update provided fields
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "taskJobs", source = "taskJobs")})// TaskJobMapper handles element mapping

    void updateTaskProfile(TaskProfileRequest taskProfileRequest, @MappingTarget TaskProfile taskProfile);
}
//TODO: CHECK IF THERE ARE ANY OTHER CASE OF RECURSION