package com.example.polyclinicapp.controller;

import com.example.polyclinicapp.model.Appointment;
import com.example.polyclinicapp.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final AppointmentService appointmentService;

    public ProfileController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping()
    public String showAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.findUsersAppointments());
        return "profile";
    }

    @GetMapping("/{index}")
    public String deleteAppointment(@PathVariable int index) {
        List<Appointment> appointments = appointmentService.findUsersAppointments();
        Appointment appointment = appointments.get(index);
        System.out.println(appointment.getId());
        appointmentService.deleteAppointment(appointment);
        return "redirect:/profile";
    }
}
