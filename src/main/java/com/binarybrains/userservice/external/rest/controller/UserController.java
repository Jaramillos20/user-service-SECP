package com.binarybrains.userservice.external.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binarybrains.userservice.core.buisness.input.UserService;
import com.binarybrains.userservice.external.rest.dto.UserDto;
import com.binarybrains.userservice.utils.error.UserException;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ApiResponses({
        @ApiResponse(responseCode = "200",description = "User found successfully", content = {@Content(schema = @Schema(implementation = UserDto.class))}),
        @ApiResponse(responseCode = "404", description = "User not found", content= @Content( schema= @Schema(example = "{\"error\": \"User not found\"}"))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUsersById(@PathVariable Integer id) {
        return userService.getById(id)
        .map(user -> ResponseEntity.ok(UserDto.fromEntity(user)))
        .getOrElseGet(errorInfo -> {
            throw new UserException(errorInfo);
        });
    }
} 
