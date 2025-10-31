package com.roberto.main.mappers.tasks;

import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.dtos.tasks.TaskTagDto;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.models.tasks.TaskTag;
import com.roberto.main.requests.anagraficas.UserRequest;
import com.roberto.main.requests.tasks.TaskTagRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TaskTagMapper {


    // Request -> Entity
    TaskTag toTaskTag(TaskTagRequest request);

    // Entity -> DTO (adjust/extend if you need it)
    @Mappings({
            @Mapping(target = "tasksDtos", ignore = true)
    })
    TaskTagDto toTaskTagDto(TaskTag tag);

    @Mappings({
            @Mapping(target = "tasksDtos", ignore = true)
    })
    TaskTagRequest userToTaskTagRequest(TaskTag taskTag);


    @IterableMapping(qualifiedByName = "TaskTagToTaskTagDtoNamed")
    List<TaskTagDto> toTaskTagDtos(List<TaskTag> taskTags);

    // Give the single mapping a name so the list method can reuse it
    @Named("TaskTagToTaskTagDtoNamed")
    TaskTagDto _toTaskTagDto(TaskTag tag);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromRequest(TaskTagRequest taskTagRequest, @MappingTarget TaskTag taskTag);

}
