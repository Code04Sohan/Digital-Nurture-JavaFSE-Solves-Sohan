package com.cognizant.orm_learn;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.SkillService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockRepository stockRepository;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        // All Services as per HOL
        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        LOGGER.info("Starting Hands-on All Execution...");

        try {
            testFindCountryByCode();
            testAddCountry();
            testUpdateCountry();
            testDeleteCountry();
            testSearchCountryByName();
            testSearchCountriesByPartialName();
            testSearchCountriesByPartialNameAsc();
            testSearchCountriesStartingWith();
            testFindFBInSept2019();
            testFindGoogleGreaterThan1250();
            testFindTop3HighestVolume();
            testFindTop3LowestNetflix();
            testAddEmployee();
            testGetEmployee();
            testUpdateEmployee();
            testGetDepartment();
            testAddSkillToEmployee();
            testGetEmployee();
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error occurred: ", e);
        }
    }

    // Test Feature 1
    private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("Start testFindCountryByCode()");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End testFindCountryByCode()");
    }

    // Test Feature 2
    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start testAddCountry()");
        Country newCountry = new Country();
        newCountry.setCode("XX");
        newCountry.setName("New Test Country");
        countryService.addCountry(newCountry);
        Country result = countryService.findCountryByCode("XX");
        LOGGER.debug("Added Country: {}", result);
        LOGGER.info("End testAddCountry()");
    }

    // Test Feature 3
    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start testUpdateCountry()");
        countryService.updateCountry("XX", "Updated Test Country");
        Country updatedCountry = countryService.findCountryByCode("XX");
        LOGGER.debug("Updated Country: {}", updatedCountry);
        LOGGER.info("End testUpdateCountry()");
    }

    // Test Feature 4
    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry()");
        countryService.deleteCountry("XX");
        LOGGER.info("Deleted Country Code XX successfully.");
        LOGGER.info("End testDeleteCountry()");
    }

    // Test Feature 5
    private static void testSearchCountryByName() {
        LOGGER.info("Start testSearchCountryByName()");
        List<Country> countries = countryService.searchCountryByName("ou");
        LOGGER.debug("Found {} countries matching 'ou'", countries.size());
        for (Country c : countries) {
            LOGGER.debug("Match: {}", c.getName());
        }
        LOGGER.info("End testSearchCountryByName()");
    }

    // ===================================================================================

    // [Solves] 2. spring-data-jpa-handson Hands on 1 answers
    // 1. Test method for partial search ("ou")
    private static void testSearchCountriesByPartialName() {
        LOGGER.info("Start testSearchCountriesByPartialName()");
        List<Country> countries = countryService.searchCountriesByPartialName("ou");
        for (Country country : countries) {
            LOGGER.debug("{}\t{}", country.getCode(), country.getName());
        }
        LOGGER.info("End testSearchCountriesByPartialName()");
    }

    // 2. Test method for partial search ascending ("ou")
    private static void testSearchCountriesByPartialNameAsc() {
        LOGGER.info("Start testSearchCountriesByPartialNameAsc()");
        List<Country> countries = countryService.searchCountriesByPartialNameAsc("ou");
        for (Country country : countries) {
            LOGGER.debug("{}\t{}", country.getCode(), country.getName());
        }
        LOGGER.info("End testSearchCountriesByPartialNameAsc()");
    }

    // 3. Test method for starting alphabet ("Z")
    private static void testSearchCountriesStartingWith() {
        LOGGER.info("Start testSearchCountriesStartingWith()");
        List<Country> countries = countryService.searchCountriesStartingWith("Z");
        for (Country country : countries) {
            LOGGER.debug("{}\t{}", country.getCode(), country.getName());
        }
        LOGGER.info("End testSearchCountriesStartingWith()");
    }

    // [Solves] 2. spring-data-jpa-handson Hands on 2 answers
    private static void testFindFBInSept2019() {
        LOGGER.info("--- 1. FB Stocks in Sept 2019 ---");
        Date startDate = Date.valueOf("2019-09-01");
        Date endDate = Date.valueOf("2019-09-30");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", startDate, endDate);
        stocks.forEach(stock -> LOGGER.debug(stock.toString()));
    }

    private static void testFindGoogleGreaterThan1250() {
        LOGGER.info("--- 2. GOOGL Stocks > 1250 ---");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250.0);
        stocks.forEach(stock -> LOGGER.debug(stock.toString()));
    }

    private static void testFindTop3HighestVolume() {
        LOGGER.info("--- 3. Top 3 Highest Volume Transactions ---");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        stocks.forEach(stock -> LOGGER.debug(stock.toString()));
    }

    private static void testFindTop3LowestNetflix() {
        LOGGER.info("--- 4. Top 3 Lowest NFLX Stocks ---");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        stocks.forEach(stock -> LOGGER.debug(stock.toString()));
    }

    // ===================================================================================

    // [Solves] 2. spring-data-jpa-handson Hands on 4 answers
    private static void testAddEmployee() {
        LOGGER.info("Start testAddEmployee()");

        Employee employee = new Employee();
        employee.setName("Sohan");
        employee.setSalary(65000.00);
        employee.setPermanent(true);

        // Make sure you have 'import java.sql.Date;' at the top of the file
        Date dob = Date.valueOf("2000-01-01");
        employee.setDateOfBirth(dob);

        // Fetch Department ID 1 (Engineering)
        Department dept = departmentService.get(1);
        employee.setDepartment(dept);

        employeeService.save(employee);

        LOGGER.debug("Saved Employee: {}", employee);
        LOGGER.info("End testAddEmployee()");
    }

    private static void testGetEmployee() {
        LOGGER.info("Start testGetEmployee()");
        // Fetch the employee we just added (ID 1)
        Employee employee = employeeService.get(1);

        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.info("End testGetEmployee()");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start testUpdateEmployee()");

        // Fetch Employee ID 1
        Employee employee = employeeService.get(1);

        // Fetch a different department, ID 2 (Human Resources)
        Department newDept = departmentService.get(2);

        // Update the employee's department
        employee.setDepartment(newDept);
        employeeService.save(employee);

        LOGGER.debug("Updated Employee: {}", employee);
        LOGGER.debug("New Department: {}", employee.getDepartment());
        LOGGER.info("End testUpdateEmployee()");
    }


    // ===================================================================================

    // [Solves] 2. spring-data-jpa-handson Hands on 5 answers
    private static void testGetDepartment() {
        LOGGER.info("Start testGetDepartment()");

        // Fetch Department ID 1 (Engineering).
        Department dept = departmentService.get(1);

        LOGGER.debug("Department: {}", dept);

        // Attempting to retrieve the associated employees.
        // This is safe because Department.toString() does not call Employee.toString()
        // in an infinite loop.
        LOGGER.debug("Department Employees: {}", dept.getEmployeeList());

        LOGGER.info("End testGetDepartment()");
    }

    // [Solves] 2. spring-data-jpa-handson Hands on 6 answers
    private static void testAddSkillToEmployee() {
        LOGGER.info("Start testAddSkillToEmployee()");
        
        // Fetch Employee ID 1 
        Employee employee = employeeService.get(1);
        
        // Fetch Skill ID 1 (e.g., Java)
        Skill skill = skillService.get(1);
        
        // Add skill to employee's skill list
        Set<Skill> skillList = employee.getSkillList();
        skillList.add(skill);
        employee.setSkillList(skillList);
        
        // Save the updated employee
        employeeService.save(employee);
        
        LOGGER.info("End testAddSkillToEmployee()");
    }
}