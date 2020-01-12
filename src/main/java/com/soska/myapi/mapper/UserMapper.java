package com.soska.myapi.mapper;

import com.soska.myapi.dto.UserDto;
import com.soska.myapi.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userEntityToUserDto(User user);
}