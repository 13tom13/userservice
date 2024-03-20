package com.tom13.userservice.controller;

import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping("/users")
    public String listRegisteredUsers(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/users/deactivation/{id}")
    public String deactivationUser(@PathVariable long id) {
        userService.deactivationUser(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/activation/{id}")
    public String activationUser(@PathVariable long id) {
        userService.activationUser(id);
        return "redirect:/admin/users";
    }

}
