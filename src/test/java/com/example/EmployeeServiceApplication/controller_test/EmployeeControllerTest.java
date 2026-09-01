package com.example.EmployeeServiceApplication.controller_test;

import com.example.EmployeeServiceApplication.controller.EmployeeController;
import com.example.EmployeeServiceApplication.domain.Employee;
import com.example.EmployeeServiceApplication.dto.EmployeeDto;
import com.example.EmployeeServiceApplication.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void createEmployee_WhenValidInput_ShouldReturn201() throws Exception {
        EmployeeDto requestDto = new EmployeeDto();
        requestDto.setName("Sainath");
        requestDto.setAddress("Pune");
        requestDto.setPosition("Developer");

        Employee responseDto = new Employee(1L, "Sainath", "Pune", "Developer","Dev");

        when(employeeService.saveEmployee(any(EmployeeDto.class))).thenReturn(responseDto);

        mockMvc.perform(post("/api/employees/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Sainath"));
    }

    @Test
    void getEmployeeById_ShouldReturn200AndEmployee() throws Exception {
        Employee responseDto = new Employee(1L, "Sainath", "Pune", "Developer");

        when(employeeService.getEmployeeById(1L)).thenReturn(responseDto);

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sainath"))
                .andExpect(jsonPath("$.position").value("Developer"));
    }
}