package com.example.polyclinicapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }
}
