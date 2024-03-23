package com.tom13.userservice.exception;


public abstract class UserServiceError extends RuntimeException {

    public UserServiceError(String message) {
        super(message);
    }
}
