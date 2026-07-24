package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(5, 5);
        // Assert that 5 + 5 equals 10
        assertEquals("5 + 5 should equal 10", 10, result);
    }
}