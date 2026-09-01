package com.example.departmentservice.dto;


import java.util.List;

public class DepartmentResponseDto {
    private Long id;
    private String departmentName;
    private String departmentCode;
    private String departmentAddress;
    private List<EmployeeDto> employees;

    public DepartmentResponseDto() {
    }

    public DepartmentResponseDto(Long id, String departmentName, String departmentCode, String departmentAddress, List<EmployeeDto> employees) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.departmentAddress = departmentAddress;
        this.employees = employees;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }

    public String getDepartmentAddress() { return departmentAddress; }
    public void setDepartmentAddress(String departmentAddress) { this.departmentAddress = departmentAddress; }

    public List<EmployeeDto> getEmployees() { return employees; }
    public void setEmployees(List<EmployeeDto> employees) { this.employees = employees; }
}
