package com.example.polyclinicapp.service;

import com.example.polyclinicapp.model.Appointment;
import com.example.polyclinicapp.model.User;
import com.example.polyclinicapp.repository.AppointmentRepository;
import com.example.polyclinicapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final UserRepository userRepository;


    public AppointmentService(AppointmentRepository appointmentRepository,
                              UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    public Appointment addToUser(Appointment appointment){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        if(user==null) return null;
        appointment.setUser(user);
        appointment = appointmentRepository.save(appointment);
        return appointment;
    }

    public List<Appointment> findUsersAppointments(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        return appointmentRepository.getAppointmentsByUser(user);
    }

    public void deleteAppointment(Appointment appointment){
        appointmentRepository.deleteById(appointment.getId());

    }
}
