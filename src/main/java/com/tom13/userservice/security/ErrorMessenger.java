package com.tom13.userservice.security;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Component
public class ErrorMessenger {

    private String message;
}
