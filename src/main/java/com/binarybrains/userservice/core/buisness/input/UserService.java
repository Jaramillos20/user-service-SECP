package com.binarybrains.userservice.core.buisness.input;

import com.binarybrains.userservice.core.entity.User;

public interface UserService {
    User getById(Integer id);    
}
