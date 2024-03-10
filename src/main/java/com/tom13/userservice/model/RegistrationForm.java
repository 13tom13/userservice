package com.tom13.userservice.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Data
public class RegistrationForm {
    private String name;
    private String email;
    private String password;
    private RoleDTO roleDTO;

//    public User toUser(PasswordEncoder passwordEncoder) {
//        User user = new User(name, email, passwordEncoder.encode(password), roleDTO);
//        System.out.println("new user: " + user);
//        return user;
//    }
}
