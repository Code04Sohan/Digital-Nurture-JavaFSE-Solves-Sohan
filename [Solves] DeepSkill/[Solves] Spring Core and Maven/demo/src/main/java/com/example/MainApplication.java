package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.service.BookService;

public class MainApplication {
    public static void main(String[] args) {
        // Load the configuration file from resources
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Grab the fully configured BookService from the Spring Context
        BookService bookService = (BookService) context.getBean("bookService");

        // Execute the method!
        bookService.registerNewBook();
    }
}