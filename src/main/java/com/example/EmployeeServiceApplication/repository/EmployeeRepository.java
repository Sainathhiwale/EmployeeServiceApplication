package com.example.EmployeeServiceApplication.repository;

import com.example.EmployeeServiceApplication.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByPosition(String developer);
}
