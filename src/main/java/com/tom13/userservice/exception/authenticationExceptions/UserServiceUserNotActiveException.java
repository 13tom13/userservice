package com.tom13.userservice.exception.authenticationExceptions;

import com.tom13.userservice.exception.UserServiceError;

public class UserServiceUserNotActiveException extends UserServiceError {

    public UserServiceUserNotActiveException(String message) {
        super(message);
    }
}
