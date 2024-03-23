package com.tom13.userservice.controller;

import com.tom13.userservice.security.ErrorMessenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthenticationController {

    private final ErrorMessenger errorMessenger;

    @GetMapping
    public String home() {
        System.out.println("index");
        return "index";
    }

    @ModelAttribute
    public void loginError(Model model) {
//        String errorMessage = "Ваше сообщение об ошибке здесь";
        model.addAttribute("error", errorMessenger.getMessage());
    }

    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }

//    @ModelAttribute
//    public String login(Model model) {
//        model.addAttribute("error", errorMessenger.getMesseng());
//        return "login"; // Имя представления
//    }

}
