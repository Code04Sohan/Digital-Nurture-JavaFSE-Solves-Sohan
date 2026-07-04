package com.example.library_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // 1. Add this to tell Spring this class handles web requests
public class LibraryManagementApplication {

    public static void main(String[] args) {
        // This line boots up the Spring engine
        SpringApplication.run(LibraryManagementApplication.class, args);
        
        // This will still print to your terminal right after startup finishes!
        System.out.println("\n=================================");
        System.out.println("HELLO WORLD FROM SPRING BOOT TERMINAL!");
        System.out.println("=================================\n");
    }

    // 2. Add your webpage code directly inside the class block
    @GetMapping("/") 
    public String sayHelloWeb() {
        return "<h1>Hello World!</h1><p>Your Library Management Web Server is officially online directly from this class file!</p>";
    }
}