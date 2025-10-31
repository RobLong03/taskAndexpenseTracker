package com.roberto.main.mappers.anagraficas;

import com.roberto.main.dtos.anagraficas.UserDto;
import com.roberto.main.models.anagraficas.User;
import com.roberto.main.requests.anagraficas.UserRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,uses = { ExpenseProfileMapper.class} )
public interface UserMapper {

    UserDto userToUserDto(User user);
    @IterableMapping(qualifiedByName = "userToUserDtoNamed")
    List<UserDto> toUserDtos(List<User> users);

    // Give the single mapping a name so the list method can reuse it
    @Named("userToUserDtoNamed")
    UserDto _userToUserDto(User user);

    // --- Request <-> Entity / DTO
    @Mappings({
            // keep only fields that differ in name; identical names don’t need mappings
            @Mapping(target = "financialProfile", source = "financialProfileRequest")
    })   // if your UserRequest also uses "Id"
    User toUser(UserRequest userRequest);

    @Mappings({
            @Mapping(target = "financialProfile", source = "financialProfileRequest")
    })
    UserDto toUserDto(UserRequest userRequest);

    @Mappings({
            @Mapping(target = "financialProfileRequest", source = "financialProfile"),
    })
    UserRequest toUserRequest(UserDto userDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "financialProfile", source = "financialProfileRequest")
    })
    void updateUserFromRequest(UserRequest userRequest, @MappingTarget User userSave);
}
