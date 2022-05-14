package com.example.polyclinicapp.controller;

import com.example.polyclinicapp.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentsController {
    final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("deps", departmentService.getAllDepartments());
        return "home";
    }

    @GetMapping("/departments")
    public String show(Model model) {
        model.addAttribute("deps", departmentService.getAllDepartments());
        return "departments";
    }
}

