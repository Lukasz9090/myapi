package com.soska.myapi.mapper;

import com.soska.myapi.dto.UserWithDetailsDto;
import com.soska.myapi.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserWithDetailsMapper {

    @Mapping(source = "account", target = "accountDto")
    UserWithDetailsDto userEntityToUserWithDetailsDto(User user);
}