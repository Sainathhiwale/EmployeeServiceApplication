package com.example.EmployeeServiceApplication.repository_test;

import com.example.EmployeeServiceApplication.domain.Employee;
import com.example.EmployeeServiceApplication.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findByPosition_ShouldReturnMatchingEmployees() {
        // Arrange (using builder to avoid constructor mismatch)
        Employee emp1 = Employee.builder()
                .name("Sainath")
                .address("Pune")
                .position("Developer")
                .departmentCode("Dev")
                .build();

        Employee emp2 = Employee.builder()
                .name("Alex")
                .address("Mumbai")
                .position("Manager")
                .departmentCode("MGR")
                .build();
        Employee emp3 = Employee.builder()
                .name("Alex")
                .address("Mumbai")
                .position("QA")
                .build();

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);

        // Act
        List<Employee> developers = employeeRepository.findByPosition("Developer");

        // Assert
        assertEquals(1, developers.size());
        assertEquals("Sainath", developers.get(0).getName());
    }
}