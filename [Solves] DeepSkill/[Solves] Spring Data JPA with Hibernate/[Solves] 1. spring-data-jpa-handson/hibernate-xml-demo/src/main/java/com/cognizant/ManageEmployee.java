package com.cognizant;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
    
    private static SessionFactory factory; 

    public static void main(String[] args) {
        try {
            // 1. Initialize SessionFactory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
        }
        
        ManageEmployee ME = new ManageEmployee();

        // 2. Add a few employee records in database (Uses session.save)
        Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 10000);

        // 3. List down all the employees (Uses session.createQuery().list())
        System.out.println("\n--- Listing All Employees ---");
        ME.listEmployees();

        // 4. Get a specific employee (Uses session.get())
        System.out.println("\n--- Getting Employee ID: " + empID1 + " ---");
        ME.getEmployee(empID1);

        // 5. Delete an employee (Uses session.delete())
        System.out.println("\n--- Deleting Employee ID: " + empID2 + " ---");
        ME.deleteEmployee(empID2);

        // List down new list of the employees
        System.out.println("\n--- Listing Employees After Deletion ---");
        ME.listEmployees();
        
        factory.close();
    }

    // Uses session.save(), beginTransaction(), and commit()
    public Integer addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee); 
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
        return employeeID;
    }

    // Uses session.createQuery().list()
    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            List<Employee> employees = session.createQuery("FROM Employee").list(); 
            for (Employee employee : employees) {
                System.out.print("First Name: " + employee.getFirstName()); 
                System.out.print("  Last Name: " + employee.getLastName()); 
                System.out.println("  Salary: " + employee.getSalary()); 
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    // Uses session.get()
    public void getEmployee(Integer EmployeeID) {
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, EmployeeID); 
            if(employee != null){
                System.out.println("Found Employee - Name: " + employee.getFirstName() + " " + employee.getLastName());
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    // Uses session.delete()
    public void deleteEmployee(Integer EmployeeID) {
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, EmployeeID); 
            if(employee != null) {
                session.delete(employee); 
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }
}