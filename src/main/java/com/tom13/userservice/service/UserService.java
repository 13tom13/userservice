package com.tom13.userservice.service;


import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    void deletUser(String email);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
