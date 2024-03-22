package com.tom13.userservice.controller;

import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.entity.Role;
import com.tom13.userservice.entity.User;
import com.tom13.userservice.repository.RoleRepository;
import com.tom13.userservice.service.RegistrationService;
import com.tom13.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationСontroller {

    private final RegistrationService registrationService;

    private final RoleRepository roleRepository;

    @GetMapping()
    public String registrationForm() {
        return "register";
    }

    @PostMapping("/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        try {
            registrationService.registerNewUser(userDto);
        } catch (IllegalArgumentException e) {
            result.rejectValue("email", null, e.getMessage());
            return "register";
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register";
        }
        return "redirect:/register?success";
    }

    @ModelAttribute
    public void addUserDtoToModel(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
    }

    @ModelAttribute
    public void addRolesToModel(Model model) {
        model.addAttribute("roleList", roleRepository.findAllNames());
    }

}
