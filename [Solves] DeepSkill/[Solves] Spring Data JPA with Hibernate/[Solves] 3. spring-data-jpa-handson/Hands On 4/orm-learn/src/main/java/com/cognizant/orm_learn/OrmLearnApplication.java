package com.cognizant.orm_learn;

import  java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    
    // Only keeping the service needed for this specific hands-on
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        
        // Autowire the EmployeeService
        employeeService = context.getBean(EmployeeService.class);

        LOGGER.info("Starting Hands-on 4 (Average Salary) HQL Execution...");

        try {
            testGetAverageSalary();
            testGetAllEmployeesNative();
            testGetAllEmployeesCriteria();
        } catch (Exception e) {
            LOGGER.error("Error occurred: ", e);
        }
    }

    // ============================================================
    // ======= [Solves] HQL Hands-on 4: Average Salary ============
    // ============================================================
    
    private static void testGetAverageSalary() {
        LOGGER.info("Start testGetAverageSalary()");
        
        // Testing for Department ID 1 (which we populated in earlier hands-on exercises)
        int departmentId = 1;
        double averageSalary = employeeService.getAverageSalary(departmentId);
        
        LOGGER.debug("Average Salary for Department ID {} is: {}", departmentId, averageSalary);
        
        LOGGER.info("End testGetAverageSalary()");
    }

    // ============================================================
    // ======= [Solves] HQL Hands-on 5: Native Query ==============
    // ============================================================
    
    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start testGetAllEmployeesNative()");
        
        List<Employee> employees = employeeService.getAllEmployeesNative();
        
        // Iterate and print out the employees fetched via Native SQL
        for (Employee employee : employees) {
            LOGGER.debug("Native Employee Fetch: {}", employee.toString());
        }
        
        LOGGER.info("End testGetAllEmployeesNative()");
    }

    // ============================================================
    // ======= [Solves] HQL Hands-on 6: Criteria Query ============
    // ============================================================
    
    private static void testGetAllEmployeesCriteria() {
        LOGGER.info("Start testGetAllEmployeesCriteria()");
        
        List<Employee> employees = employeeService.getAllEmployeesCriteria();
        
        for (Employee employee : employees) {
            LOGGER.debug("Criteria Query Employee Fetch: {}", employee.toString());
        }
        
        LOGGER.info("End testGetAllEmployeesCriteria()");
    }
}