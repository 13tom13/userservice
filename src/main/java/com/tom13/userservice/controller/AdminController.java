package com.tom13.userservice.controller;

import com.tom13.userservice.dto.UserDto;
import com.tom13.userservice.entity.User;
import com.tom13.userservice.service.UserService;
import jakarta.servlet.http.HttpSession;
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
    public String listRegisteredUsers(Model model, HttpSession session, @RequestParam(defaultValue = "firstName") String sortBy) {
        boolean sortAscending = getSessionSortDirection(session);
        List<UserDto> users = userService.findAllUsersSortedBy(sortBy, sortAscending);
        model.addAttribute("users", users);
        toggleSessionSortDirection(session);
        return "users";
    }

    private boolean getSessionSortDirection(HttpSession session) {
        Boolean sortAscending = (Boolean) session.getAttribute("sortAscending");
        return sortAscending != null ? sortAscending : true;
    }

    private void toggleSessionSortDirection(HttpSession session) {
        Boolean sortAscending = (Boolean) session.getAttribute("sortAscending");
        session.setAttribute("sortAscending", sortAscending == null || !sortAscending);
    }

    @PostMapping("/users/deactivation/{id}")
    public String deactivationUser(@PathVariable long id) {
        userService.deactivationUser(id);
        return "redirect:/admin/users";
    }
    //TODO: решить проблему с активацеик

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

    @PostMapping("/updateFirstName/{id}")
    public String updateUserFirstName(@PathVariable long id, @RequestParam("newFirstName") String newFirstName){
        userService.updateUserFirstName(id, newFirstName);
        return "redirect:/account?successFirstName";
    }

    @PostMapping("/updateLastName/{id}")
    public String updateUserLastName(@PathVariable long id, @RequestParam("newLastName") String newLastName){
        userService.updateUserLastName(id, newLastName);
        return "redirect:/account?successLastName";
    }

}
