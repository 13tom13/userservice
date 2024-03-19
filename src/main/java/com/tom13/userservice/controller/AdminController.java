package com.tom13.userservice.controller;

import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    @GetMapping("/users")
//    @RolesAllowed("ADMIN")
//    public String deletUserFromDB(String email) {
//        userService.delet
//        model.addAttribute("users", users);
//        return "users";
//    }

}
