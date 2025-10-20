package com.binarybrains.userservice.core.buisness.input;

import com.binarybrains.userservice.core.entity.User;

public interface UserService {
    User create(User user);    
    User getById(Long id);
    boolean deteleById(Long id);
    User update(User user);
}
