package com.tom13.userservice.service;


import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.entity.User;

import java.util.List;

public interface UserService {

    void deactivationUser(Long id);

    void activationUser(Long id);

    User findByEmail(String email);

    List<UserDto> findAllUsers();

    UserDto findById(Long id);

    UserDto updateUserFirstName(Long id, String newFirsName);

    UserDto updateUserLastName(Long id, String newLastName);
}
