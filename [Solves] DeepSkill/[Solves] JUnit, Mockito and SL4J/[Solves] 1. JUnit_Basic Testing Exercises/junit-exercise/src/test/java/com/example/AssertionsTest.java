package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AssertionsTest { 
    
    @Test 
    public void testAssertions() { 
        // Assert equals: Checks if two values are identical
        assertEquals(5, 2 + 3); 
 
        // Assert true: Checks if a condition evaluates to true
        assertTrue(5 > 3); 
 
        // Assert false: Checks if a condition evaluates to false
        assertFalse(5 < 3); 
 
        // Assert null: Checks if an object is null
        assertNull(null); 
 
        // Assert not null: Checks if an object is NOT null
        assertNotNull(new Object()); 
    } 
}