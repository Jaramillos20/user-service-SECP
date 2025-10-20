package com.binarybrains.userservice.external.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binarybrains.userservice.core.buisness.input.UserService;
import com.binarybrains.userservice.external.rest.dto.UserDto;


@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String getMethodName(@RequestParam UserDto userDto) {
        return userService.create(userDto.toEntity()).toString();
    }
    
}
