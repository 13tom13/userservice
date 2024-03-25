package com.tom13.userservice.service.impl;

import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.entity.User;
import com.tom13.userservice.repository.RoleRepository;
import com.tom13.userservice.repository.UserRepository;
import com.tom13.userservice.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerNewUser(UserDto userDto) {
        User existing = userRepository.findByEmail(userDto.getEmail());
        if (existing != null) {
            throw new IllegalArgumentException("There is already an account registered with that email");
        }
        User userFromUserDTO = CreatNewUserFromUserDTO(userDto);
        userRepository.save(userFromUserDTO);
    }

    private User CreatNewUserFromUserDTO(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setIsActive(true);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(roleRepository.findByNameIn(userDto.getRoles()));
        return user;
    }
}
