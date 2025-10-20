package com.binarybrains.userservice.core.buisness.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarybrains.userservice.core.buisness.input.UserService;
import com.binarybrains.userservice.core.buisness.output.UserRepository;
import com.binarybrains.userservice.core.entity.User;

@Service
public class UserBs implements UserService{
    @Autowired
    private final UserRepository userRepository;
    public UserBs(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
}