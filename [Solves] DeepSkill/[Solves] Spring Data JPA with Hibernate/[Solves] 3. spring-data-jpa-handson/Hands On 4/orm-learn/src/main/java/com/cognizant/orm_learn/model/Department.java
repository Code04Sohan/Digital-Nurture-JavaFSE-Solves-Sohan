package com.cognizant.orm_learn.model;

import java.util.Set; // Added import for Set

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; // Added import for FetchType
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table; // Added import for OneToMany

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dp_id")
    private int id;

    @Column(name="dp_name")
    private String name;

    // Change this:
    // @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    //      V
    // To this:
    @OneToMany(mappedBy = "department")
    private Set<Employee> employeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // --- NEW GETTER AND SETTER ---
    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        // Important: Do not add employeeList to this toString() method, 
        // otherwise it will cause an infinite loop when printing!
        return "Department [id=" + id + ", name=" + name + "]";
    }
}