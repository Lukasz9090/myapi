package com.soska.myapi.user;

import com.soska.myapi.dto.UserDto;
import com.soska.myapi.dto.UserWithDetailsDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserWithDetailsDto getUserById(Long id);
}
