package com.binarybrains.userservice.core.buisness.input;

import com.binarybrains.userservice.core.entity.User;
import com.binarybrains.userservice.utils.ErrorCode;

import io.vavr.control.Either;

public interface UserService {
    Either<User, ErrorCode> getById(Integer id);    
}
