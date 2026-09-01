package com.example.EmployeeServiceApplication.service_test;

import com.example.EmployeeServiceApplication.domain.Employee;
import com.example.EmployeeServiceApplication.dto.EmployeeDto;
import com.example.EmployeeServiceApplication.repository.EmployeeRepository;
import com.example.EmployeeServiceApplication.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void createEmployee_ShouldSaveAndReturnResponseDto() {
        EmployeeDto requestDto = new EmployeeDto();
        requestDto.setName("Sainath");
        requestDto.setAddress("Pune");
        requestDto.setPosition("Developer");

        Employee savedEmployee = Employee.builder()
                .id(1L)
                .name("Sainath")
                .address("Pune")
                .position("Developer")
                .build();

        when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

        Employee result = employeeService.saveEmployee(requestDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Sainath", result.getName());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void getEmployeeById_WhenNotFound_ShouldThrowException() {
        when(employeeRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> employeeService.getEmployeeById(99L));
        verify(employeeRepository, times(1)).findById(99L);
    }
}