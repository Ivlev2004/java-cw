package com.example.payday.controllers;

import com.example.payday.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasAnyAuthority('ROLE_ACCOUNTANT')")
public class AccountantController {
    private final UserService userService;

    public AccountantController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/employees")
    public String admin(Model model) {
        model.addAttribute("users", userService.list());
        return "employees";
    }
}
