package com.example.EmployeeServiceApplication.run_suit;

import com.example.EmployeeServiceApplication.controller_test.EmployeeControllerTest;
import com.example.EmployeeServiceApplication.repository_test.EmployeeRepositoryTest;
import com.example.EmployeeServiceApplication.service_test.EmployeeServiceTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Employee Service Complete Test Suite")
@SelectClasses({
        EmployeeServiceTest.class,
        EmployeeRepositoryTest.class,
        EmployeeControllerTest.class
})
public class EmployeeServiceTestSuite {
}
