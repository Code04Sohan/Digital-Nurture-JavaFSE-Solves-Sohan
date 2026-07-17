package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.BookService;

public class MainApplication {
    public static void main(String[] args) {
        // Use try-with-resources to ensure the context is closed automatically
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            // Grab the fully configured BookService from the Spring Context
            BookService bookService = context.getBean("bookService", BookService.class);

            // Execute the method!
            bookService.registerNewBook();
        }
    }
}