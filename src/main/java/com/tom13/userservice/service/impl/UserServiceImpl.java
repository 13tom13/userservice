package com.tom13.userservice.service.impl;

import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.entity.Role;
import com.tom13.userservice.entity.User;
import com.tom13.userservice.repository.RoleRepository;
import com.tom13.userservice.repository.UserRepository;
import com.tom13.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        User userFromUserDTO = CreatNewUserFromUserDTO(userDto);
        userRepository.save(userFromUserDTO);
    }

    private User CreatNewUserFromUserDTO(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(roleRepository.findByNameIn(userDto.getRoles()));
        return user;
    }

    @Override
    public void deletUser(String email) {

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles().stream()
                .map(Role::getName)
                .map(s -> s.substring(5).toLowerCase())
                .collect(Collectors.toList()));
        return userDto;
    }

}
