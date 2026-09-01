package com.example.departmentservice.services;

import com.example.departmentservice.domain.Department;
import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.dto.DepartmentResponseDto;
import com.example.departmentservice.dto.EmployeeDto;
import com.example.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RestClient employeeRestClient;

    public Department saveDepartment(DepartmentDto departmentDto){
        Department department = new Department();
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentAddress(departmentDto.getDepartmentAddress());
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId){
        return departmentRepository.findById(departmentId)
        .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
    }
    public DepartmentResponseDto getDepartmentWithEmployees(Long departmentId) {
        // 1. Fetch Department from local DB
        Department department = getDepartmentById(departmentId);

        // 2. Call EmployeeService over HTTP
        List<EmployeeDto> employees = employeeRestClient.get()
                .uri("/api/employees/by-department/{code}", department.getDepartmentCode())
                .retrieve()
                .body(new ParameterizedTypeReference<List<EmployeeDto>>() {});

        // 3. Assemble and return composite response
        return new DepartmentResponseDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getDepartmentAddress(),
                employees
        );
    }
}
