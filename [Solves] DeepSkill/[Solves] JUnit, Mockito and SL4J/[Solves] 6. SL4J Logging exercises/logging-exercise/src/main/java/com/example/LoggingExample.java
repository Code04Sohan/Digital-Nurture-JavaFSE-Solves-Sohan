package com.example;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
 
public class LoggingExample { 
    // Initialize the logger for this specific class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class); 
 
    public static void main(String[] args) { 
        // Log an error message (highest severity)
        logger.error("This is an error message"); 
        
        // Log a warning message (medium severity)
        logger.warn("This is a warning message"); 
    } 
}