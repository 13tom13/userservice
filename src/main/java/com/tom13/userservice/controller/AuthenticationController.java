package com.tom13.userservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @GetMapping
    public String home() {
        return "index";
    }

    @ModelAttribute
    public void yourMethod(Model model) {
        // Предположим, у вас есть сообщение об ошибке, которое вы хотите передать
        String errorMessage = "Ваше сообщение об ошибке здесь";

        // Устанавливаем атрибут error в модель
        model.addAttribute("error", errorMessage);

        // Возвращаем имя представления
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

}
