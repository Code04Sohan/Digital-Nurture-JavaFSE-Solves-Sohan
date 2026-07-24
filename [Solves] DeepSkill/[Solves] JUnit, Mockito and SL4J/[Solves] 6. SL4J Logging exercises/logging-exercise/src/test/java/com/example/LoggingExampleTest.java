package com.example;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoggingExampleTest {
    
    @Test
    public void testMainMethodExecutesSuccessfully() {
        try {
            // Act: Call the main method of your logging app
            String[] args = {};
            LoggingExample.main(args);
            
            // Assert: If the method finishes without crashing, the test passes
            assertTrue("The main method should execute without throwing exceptions", true);
        } catch (Exception e) {
            // Fail the test if any unexpected exception occurs
            org.junit.Assert.fail("Exception thrown during execution: " + e.getMessage());
        }
    }
}