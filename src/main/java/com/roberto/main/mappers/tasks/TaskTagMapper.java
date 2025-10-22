package com.roberto.main.mappers.tasks;

import com.roberto.main.dtos.tasks.TaskTagDto;
import com.roberto.main.models.tasks.TaskTag;
import com.roberto.main.requests.tasks.TaskTagRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TaskTagMapper {


    // Request -> Entity
    @Mappings({
            // Avoid recursion (a tag's tasks list is usually back-reference)
            @Mapping(target = "tasks", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "description", ignore = true)
    })
    TaskTag toTaskTag(TaskTagRequest request);

    // Entity -> DTO (adjust/extend if you need it)
    @Mappings({
            @Mapping(target = "tasksDtos", ignore = true)
    })
    TaskTagDto toTaskTagDto(TaskTag tag);
}
