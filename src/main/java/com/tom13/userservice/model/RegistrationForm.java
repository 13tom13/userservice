package com.tom13.userservice.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String Fullname;
    private Boolean admin;
    private Boolean nonLocked = true;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User( username, passwordEncoder.encode(password), Fullname);
    }
}
