package com.example.departmentservice.dto;
// Employee Service DTO get her using  common-dto dependency
public class EmployeeDto {
    private Long id;
    private String name;
    private String address;
    private String position;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, String address, String position) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
