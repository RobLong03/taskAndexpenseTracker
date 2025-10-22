package com.roberto.main.mappers.tasks;

import com.roberto.main.dtos.tasks.TaskDto;
import com.roberto.main.mappers.anagraficas.ExpenseProfileMapper;
import com.roberto.main.mappers.expenses.ExpenseJobMapper;
import com.roberto.main.models.tasks.Task;
import com.roberto.main.requests.tasks.TaskRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = {ExpenseProfileMapper.class, ExpenseJobMapper.class})
public interface TaskMapper {

//due to problem with naming rules I switched maiuscole with minuscole starting letter
     @Mappings({
             @Mapping(source = "taskJob",target = "taskJobDto"),
             @Mapping(source = "taskTag",target = "taskTagDto"),
     })
     TaskDto taskToTaskDto(Task task);
     @Mappings({
             @Mapping(source = "taskJobDto",target = "taskJob"),
             @Mapping(source = "taskTagDto",target = "taskTag"),
     })
     Task taskDtoToTask(TaskDto taskDto);

     /*TODO DA CAPIRE TaskMapper.java:28:18java: No target bean properties found: can't map property "TaskTag taskTag" to "TaskTagRequest taskTag".
      *  Consider to declare/implement a mapping method: "TaskTagRequest map(TaskTag value)".
     */
     // TaskRequest taskToTaskRequest(Task task);
     // Task taskRequestToTask(TaskRequest taskRequest);

     // Request -> Entity
     @Mappings({
             // Prevent cycles if Task has a back-reference to TaskJob/TaskProfile
             @Mapping(target = "taskJob", ignore = true)
     })
     Task toTask(TaskRequest request);

     // Entity -> DTO (add ignores similarly if your DTO has back-refs)
     @Mappings({
              @Mapping(target = "taskJobDto", ignore = true) // uncomment if exists
     })
     TaskDto toTaskDto(Task task);

     //void updateExpenseProfile(Exp ||create an update

}
