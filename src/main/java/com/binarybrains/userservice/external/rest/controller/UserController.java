package com.binarybrains.userservice.external.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
 
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUsersById(@PathVariable("id") Integer id) {
        var result = userService.getById(id);
        if (result.isLeft()) {
            return ResponseEntity.ok(UserDto.fromEntity(result.getLeft()));
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
} 
