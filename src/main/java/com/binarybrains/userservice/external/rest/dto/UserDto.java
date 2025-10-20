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

    public static UserDto fromEntity(User user) {
    return UserDto.builder()
            .name(user.getName())
            .email(user.getEmail())
            .build();
}
public User toEntity() {
    return User.builder()
            .name(this.name)
            .email(this.email)
            .build();
}

}

