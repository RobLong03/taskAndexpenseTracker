package com.roberto.main.dtos.anagraficas;


import com.roberto.main.dtos.tasks.TaskJobDto;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.models.tasks.TaskJob;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskProfileDto {

    private Integer id;


    private UserDto userDto;



    private String profileType;


    private List<TaskJobDto> taskJobsDtos;
}
