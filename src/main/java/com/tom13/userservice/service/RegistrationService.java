package com.tom13.userservice.service;

import com.tom13.userservice.dto.UserDto;
import org.springframework.validation.BindingResult;

public interface RegistrationService {

    void registerNewUser(UserDto userDto);

}
