package com.tom13.userservice.exception.authenticationExceptions;

import com.tom13.userservice.exception.UserServiceError;

public class UserServiceUsernameNotFoundException extends UserServiceError {
    public UserServiceUsernameNotFoundException(String message) {
        super(message);
    }
}
