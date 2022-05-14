package com.example.polyclinicapp.repository;

import com.example.polyclinicapp.model.Appointment;
import com.example.polyclinicapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> getAppointmentsByUser(User user);

    void deleteById(Long id);
}
