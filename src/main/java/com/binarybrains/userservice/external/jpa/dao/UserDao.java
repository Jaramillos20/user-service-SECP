package com.binarybrains.userservice.external.jpa.dao;

import java.util.Optional;

import com.binarybrains.userservice.core.buisness.output.UserRepository;
import com.binarybrains.userservice.core.entity.User;

public class UserDao implements UserRepository{

    @Override
    public Optional<User> findById(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    
}
