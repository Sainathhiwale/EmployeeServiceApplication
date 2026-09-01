package com.example.EmployeeServiceApplication.service;

import com.example.EmployeeServiceApplication.domain.Employee;
import com.example.EmployeeServiceApplication.dto.EmployeeDto;
import com.example.EmployeeServiceApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(EmployeeDto employeeDto){
        Employee employee = Employee.builder()
                .name(employeeDto.getName())
                .address(employeeDto.getAddress())
                .position(employeeDto.getPosition())
                .departmentCode(employeeDto.getDepartmentCode())
                .build();
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public List<Employee>getAll(){
        return employeeRepository.findAll();
    }


}
