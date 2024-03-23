package com.tom13.userservice.exception.handler;

import com.tom13.userservice.exception.authenticationExceptions.UserServiceUserNotActiveException;
import com.tom13.userservice.exception.authenticationExceptions.UserServiceUsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserServiceExceptionHandler {

    @ExceptionHandler(UserServiceUsernameNotFoundException.class)
    public ResponseEntity<UserServiceUsernameNotFoundException> handleUsernameNotFoundException(UserServiceUsernameNotFoundException e) {
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserServiceUserNotActiveException.class)
    public ResponseEntity<UserServiceUserNotActiveException> handleUserNotActiveException(UserServiceUserNotActiveException e) {
        return new ResponseEntity<>(e, HttpStatus.FORBIDDEN);
    }
}
