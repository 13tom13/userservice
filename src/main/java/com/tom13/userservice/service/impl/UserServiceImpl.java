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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void deactivationUser(Long id) {
        userRepository.updateUserIsActive(id,false);
    }
    @Override
    public void activationUser(Long id) {
        userRepository.updateUserIsActive(id,true);
    }

    @Override
    public UserDto findById(Long id){
        User userFromDB = userRepository.findById(id).get();
        return convertEntityToDto(userFromDB);
    }

    @Override
    public UserDto updateUserFirstName(Long id, String newFirstName) {
        userRepository.updateUserFirstName(id, newFirstName);
        return findById(id);
    }

    @Override
    public UserDto updateUserLastName(Long id, String newLastName) {
        userRepository.updateUserLastName(id, newLastName);
        return findById(id);
    }


    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return convertEntityToDto(user);
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertEntityToDto)
                .sorted(Comparator.comparing(UserDto::getFirstName))
                .collect(Collectors.toList());
    }


    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setIsActive(user.getIsActive());
        userDto.setRoles(user.getRoles().stream()
                .map(Role::getName)
                .map(s -> s.substring(5).toLowerCase())
                .collect(Collectors.toList()));
        return userDto;
    }

}
