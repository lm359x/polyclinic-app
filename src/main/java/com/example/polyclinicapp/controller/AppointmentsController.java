package com.example.polyclinicapp.controller;

import com.example.polyclinicapp.model.Appointment;
import com.example.polyclinicapp.model.Department;
import com.example.polyclinicapp.service.AppointmentService;
import com.example.polyclinicapp.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/departments/{id}/create_appointment")
public class AppointmentsController {
    final
    AppointmentService appointmentService;

    final
    DepartmentService departmentService;

    public AppointmentsController(AppointmentService appointmentService, DepartmentService departmentService) {
        this.appointmentService = appointmentService;
        this.departmentService = departmentService;
    }

    @ModelAttribute
    public void getDepartmentName(@PathVariable Long id, Model model) {
        model.addAttribute("department", departmentService.getDepartment(id));
    }

    @GetMapping()
    public String newAppointment(@PathVariable Long id, Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointment";
    }

    @PostMapping
    public String createAppointment(@ModelAttribute("appointment") @Valid Appointment appointmentFromForm, BindingResult bindingResult,
                                    @ModelAttribute("department") Department department) {
        if(bindingResult.hasErrors()){
            return "appointment";
        }
        appointmentFromForm.setDepartmentName(department.getDepartmentName());
        Appointment appointment = appointmentService.addToUser(appointmentFromForm);
        if (appointment == null) {
            return "redirect:/departments";
        }
        return "redirect:/profile";
    }


}
