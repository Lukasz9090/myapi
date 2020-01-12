package com.soska.myapi.user;

import com.soska.myapi.dto.UserDto;
import com.soska.myapi.dto.UserWithDetailsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserWithDetailsDto> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}