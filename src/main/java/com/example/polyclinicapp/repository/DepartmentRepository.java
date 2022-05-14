package com.example.polyclinicapp.repository;

import com.example.polyclinicapp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAll();

    Department getById(Long id);
}
