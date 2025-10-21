package com.binarybrains.userservice.core.buisness.output;

import java.util.Optional;

import com.binarybrains.userservice.core.entity.User;

public interface  UserRepository {
    Optional<User> findById(Integer id);
}
