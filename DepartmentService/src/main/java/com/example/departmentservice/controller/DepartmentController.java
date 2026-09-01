package com.example.departmentservice.controller;

import com.example.departmentservice.domain.Department;
import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.dto.DepartmentResponseDto;
import com.example.departmentservice.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long departmentId){
        Department department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/{departmentId}/with-employees")
    public ResponseEntity<DepartmentResponseDto> getDepartmentWithEmployees(@PathVariable Long departmentId){
        DepartmentResponseDto response = departmentService.getDepartmentWithEmployees(departmentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}