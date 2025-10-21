package com.binarybrains.userservice.core.buisness.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarybrains.userservice.core.buisness.input.UserService;
import com.binarybrains.userservice.core.buisness.output.UserRepository;
import com.binarybrains.userservice.core.entity.User;
import com.binarybrains.userservice.utils.ErrorCode;

import io.vavr.control.Either;

@Service
public class UserBs implements UserService{
    @Autowired
    private final UserRepository userRepository;
    public UserBs(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Either<User, ErrorCode> getById(Integer id) {
        Either<User, ErrorCode> result = Either.right(ErrorCode.RN004);
        var userOpt = userRepository.findById(id);
        if(userOpt.isPresent()){
            result = Either.left(userOpt.get());
        }
        return result;
    }
}