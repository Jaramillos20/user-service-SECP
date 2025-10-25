package com.binarybrains.userservice.utils.error;

import lombok.Getter;

@Getter
public class UserException extends Exception {
    private final ErrorInfo errorInfo;
    public UserException(ErrorInfo errorInfo) {
        super(errorInfo.getMessage());
        this.errorInfo = errorInfo; 
    }
}
