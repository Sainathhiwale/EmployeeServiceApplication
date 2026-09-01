# 🏢 EmployeeDiary Microservice

[![Java 17](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Build Status](https://img.shields.io/badge/Build-Passing-success.svg)](#)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](#)

A production-ready **Spring Boot microservice** built following **Layered (N-Tier) Architecture** to handle employee lifecycle operations. It exposes RESTful APIs for creating, fetching, and filtering employee records, backed by **MySQL** for persistence and an in-memory **H2 Database** for isolated unit and integration testing.

---

## 🛠️ Tech Stack

- **Language & Runtime:** Java 17
- **Framework:** Spring Boot 4.x (Spring Web, Spring Data JPA)
- **Persistence & Database:** MySQL (Runtime/Dev), Hibernate, In-Memory H2 (Testing)
- **Testing:** JUnit 5 (Jupiter), Mockito, MockMvc, Spring Test Suite Engine
- **Productivity & Utilities:** Project Lombok, Jackson ObjectMapper
- **Build Tool:** Maven

---

## 🏛️ Architecture & Data Flow

This project follows a strict **Layered Architecture (Controller-Service-Repository Pattern)** to decouple transport, business rules, and persistence concerns:



## Architecture

The application follows a layered Spring Boot architecture:

```mermaid
flowchart TD
    A[Client<br/>JSON Request] --> B

    B["1. Controller Layer<br/><b>@RestController</b><br/><br/>• HTTP routing<br/>• Request/response handling<br/>• DTO validation"]

    B --> C["2. Service Layer<br/><b>@Service</b><br/><br/>• Business logic<br/>• Business validation<br/>• @Transactional management<br/>• DTO ↔ Entity mapping"]

    C --> D["3. Repository Layer<br/><b>@Repository / JpaRepository</b><br/><br/>• CRUD operations<br/>• Derived queries<br/>• JPQL / custom queries"]

    D --> E["4. Entity / Domain Layer<br/><b>@Entity</b><br/><br/>• Database table mapping<br/>• ORM relationships<br/>• Persistent domain model"]

    E --> F[(Database)]

    style A fill:#0969da,color:#fff,stroke:#0969da
    style B fill:#ddf4ff,stroke:#0969da,color:#24292f
    style C fill:#fff8c5,stroke:#bf8700,color:#24292f
    style D fill:#ffebe9,stroke:#cf222e,color:#24292f
    style E fill:#dafbe1,stroke:#1a7f37,color:#24292f
    style F fill:#8250df,color:#fff,stroke:#8250df
```


## 📂 Project Structure

```text
src
├── main
│   ├── java/com/example/EmployeeServiceApplication
│   │   ├── controller       # REST controllers exposing HTTP endpoints
│   │   ├── service          # Business logic interfaces
│   │   │   └── impl         # Service implementation & mappings
│   │   ├── repository       # Spring Data JPA repositories
│   │   ├── domain           # JPA Entities (@Entity, @Table)
│   │   └── dto              # Request and Response transfer models
│   └── resources
│       └── application.properties
└── test
    └── java/com/example/EmployeeServiceApplication
        ├── controller_test  # Web slice tests (@WebMvcTest)
        ├── service_test     # Pure Mockito tests (@ExtendWith)
        ├── repository_test  # Database slice tests (@DataJpaTest)
        └── suite            # Aggregated test suite runner (@Suite)

## **Running Tests**

# Run all tests
mvn test

# Run the complete test suite
mvn test -Dtest=EmployeeServiceTestSuite

## **Build and Run**
mvn clean install
mvn spring-boot:run
