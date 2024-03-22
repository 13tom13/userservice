package com.tom13.userservice.controller;

import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.entity.User;
import com.tom13.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@SessionAttributes("user")
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

    @GetMapping("/user/edit/{id}")
    public String getUserForEdit(@PathVariable long id, Model model){
        UserDto user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/user/edit/{id}")
    public String editUser(@PathVariable long id, Model model){
        UserDto user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }

}
