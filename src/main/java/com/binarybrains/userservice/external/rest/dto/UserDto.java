package com.binarybrains.userservice.external.rest.dto;

import com.binarybrains.userservice.core.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private String number; 

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
            .name(user.getName())
            .email(user.getEmail())
            .number(user.getNumber())
            .build();
    }
    public User toEntity() {
        return User.builder()
            .name(this.name)
            .email(this.email)
            .number(this.number)
            .build();
    }
}

