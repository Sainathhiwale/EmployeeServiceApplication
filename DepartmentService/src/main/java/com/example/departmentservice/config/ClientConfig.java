package com.example.departmentservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Bean
    public RestClient employeeRestClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:9191")
                .build();
    }
}
