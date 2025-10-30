package com.binarybrains.userservice.core.buisness.output;

import java.util.List;
import java.util.Optional;

import com.binarybrains.userservice.core.entity.User;

public interface  UserRepository {
    Optional<User> findById(Integer id);
    Optional<List<User>> findByEmail(String email);
    Optional<User> save(User user);
}
