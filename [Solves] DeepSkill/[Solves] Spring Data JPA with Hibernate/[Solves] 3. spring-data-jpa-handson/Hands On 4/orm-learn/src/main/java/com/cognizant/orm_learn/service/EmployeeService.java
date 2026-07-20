package com.cognizant.orm_learn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    // Inject the EntityManager to use the Criteria API
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Employee get(int id) {
        LOGGER.info("Start");
        return employeeRepository.findById(id).get();
    }

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Start");
        employeeRepository.save(employee);
        LOGGER.info("End");
    }

    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        LOGGER.info("Start getAllPermanentEmployees()");
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional
    public double getAverageSalary(int departmentId) {
        LOGGER.info("Start getAverageSalary()");
        return employeeRepository.getAverageSalary(departmentId);
    }

    // --- NEW METHOD FOR HANDS-ON 5 ---
    @Transactional
    public List<Employee> getAllEmployeesNative() {
        LOGGER.info("Start getAllEmployeesNative()");
        return employeeRepository.getAllEmployeesNative();
    }

    // --- NEW METHOD FOR HANDS-ON 6 ---
    @Transactional
    public List<Employee> getAllEmployeesCriteria() {
        LOGGER.info("Start getAllEmployeesCriteria()");
        
        // 1. Get the CriteriaBuilder from the EntityManager
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        
        // 2. Create a CriteriaQuery object returning Employee
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        
        // 3. Define the root of the query (equivalent to "FROM Employee")
        Root<Employee> employeeRoot = cq.from(Employee.class);
        
        // 4. Specify what to select (equivalent to "SELECT e")
        cq.select(employeeRoot);
        
        // 5. Create a TypedQuery from the CriteriaQuery and execute it
        TypedQuery<Employee> query = entityManager.createQuery(cq);
        
        return query.getResultList();
    }
}