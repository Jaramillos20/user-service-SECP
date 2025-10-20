package com.binarybrains.userservice.external.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ec01-users")
public class UserJpa {
    @Id
    private Long id;
    private String name;
    private String email;
    private String number;
    public UserJpa toEntity() {
        return UserJpa.builder()
            .id(this.id)
            .name(this.name)
            .email(this.email)
            .number(this.number)
            .build();
    }
    public static UserJpa fromEntity(UserJpa userJpa) {
        return UserJpa.builder()
            .id(userJpa.getId())
            .name(userJpa.getName())
            .email(userJpa.getEmail())
            .number(userJpa.getNumber())
            .build();
    }
}