package com.tom13.userservice.controller;
import com.tom13.userservice.model.RegistrationForm;
import com.tom13.userservice.model.Role;
import com.tom13.userservice.model.RoleDTO;
import com.tom13.userservice.model.User;
import com.tom13.userservice.repository.RoleRepository;
import com.tom13.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm() {
        return "registration";
    }
    @PostMapping
    public String processRegistration(RegistrationForm form, RoleDTO roleDTO) {
        User user = new User(form.getName(),
                form.getEmail(),passwordEncoder.encode(form.getPassword()),roleDTO.getRoleList());
        userRepo.save(user);
        return "redirect:/login";
    }

    @ModelAttribute(name = "roleDTO")
    public RoleDTO roleDTO() {
        return new RoleDTO();
    }

    @ModelAttribute(name="roles")
    public void addRolesToModel (Model model){
        List<Role> roles = roleRepo.findAll();
        model.addAttribute("roles", roles);
    }

}