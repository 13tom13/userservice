package com.tom13.userservice.controller;

import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.entity.User;
import com.tom13.userservice.security.ErrorMessenger;
import com.tom13.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@SessionAttributes("user")
public class AuthenticationController {

    private final ErrorMessenger errorMessenger;

    private final UserService userService;

    @GetMapping("/favicon.ico")
    public String favicon(){
        return "static/favicon.ico";
    }

    @GetMapping
    public String home() {
        System.out.println("index");
        return "index";
    }

    @ModelAttribute
    public void loginError(Model model) {
        model.addAttribute("error", errorMessenger.getMessage());
    }
    @ModelAttribute
    public void user(Model model) {
        model.addAttribute("user", new UserDto());
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/account")
    public String getAccountPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        UserDto userDto = userService.findByEmail(userDetails.getUsername());
        model.addAttribute("user", userDto);
        boolean isAdmin = userDetails.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
        if (isAdmin) {
            return "admin-template";
        } else {
            return "redirect:/user/account";
        }
    }

}
