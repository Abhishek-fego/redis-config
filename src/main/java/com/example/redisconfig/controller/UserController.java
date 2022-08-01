package com.example.redisconfig.controller;


import com.example.redisconfig.dto.GenericResponseDto;
import com.example.redisconfig.dto.UserDto;
import com.example.redisconfig.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public GenericResponseDto registerUser(@RequestBody UserDto userDto){
        return userService.registerUser(userDto);
    }

    @GetMapping("/user")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }
}
