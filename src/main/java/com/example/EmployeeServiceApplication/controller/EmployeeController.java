package com.example.EmployeeServiceApplication.controller;

import com.example.EmployeeServiceApplication.domain.Employee;
import com.example.EmployeeServiceApplication.dto.EmployeeDto;
import com.example.EmployeeServiceApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto) {
        // Logic to create an employee
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        // Logic to get an employee by ID
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/employees/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/by-department/{departmentCode}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String departmentCode) {
        List<Employee> employees = employeeRepository.findByDepartmentCode(departmentCode);
        return ResponseEntity.ok(employees);
    }
}
