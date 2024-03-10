package com.tom13.userservice.config;

import com.tom13.userservice.model.Role;
import com.tom13.userservice.model.User;
import com.tom13.userservice.repository.UserRepository;
import com.tom13.userservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final PasswordEncoder passwordEncoder;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public CommandLineRunner dataLoader(UserRepository userRepo, RoleRepository roleRepo) {
        return args -> {
            List<Role> allRole = roleRepo.findAll();
            userRepo.save(
                    new User("admin", "admin@mail.ru",
                            passwordEncoder.encode("password"), allRole));
        };
    }
}
