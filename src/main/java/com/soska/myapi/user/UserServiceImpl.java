package com.soska.myapi.user;

import com.soska.myapi.dto.UserDto;
import com.soska.myapi.dto.UserWithDetailsDto;
import com.soska.myapi.exception.UserNotFoundException;
import com.soska.myapi.mapper.UserMapper;
import com.soska.myapi.mapper.UserWithDetailsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserWithDetailsMapper userWithDetailsMapper;

    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper,
                           UserWithDetailsMapper userWithDetailsMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userWithDetailsMapper = userWithDetailsMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserWithDetailsDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(userWithDetailsMapper::userEntityToUserWithDetailsDto)
                .orElseThrow(() -> new UserNotFoundException("User with id : " + id +" was not found."));
    }
}