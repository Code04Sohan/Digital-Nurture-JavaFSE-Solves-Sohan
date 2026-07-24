package com.example;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
    
    private ShoppingCart cart;

    // The Setup method runs before EACH @Test is executed.
    // It creates a fresh "test fixture" so tests don't interfere with one another.
    @Before
    public void setUp() {
        cart = new ShoppingCart();
        cart.addItem("Apple"); // Starting state: 1 item in cart
    }

    // The Teardown method runs after EACH @Test is executed.
    // It is used to release resources, clear databases, or clean up memory.
    @After
    public void tearDown() {
        cart.clear();
        cart = null;
    }

    @Test
    public void testAddItem() {
        // ARRANGE: Set up the specific data needed for this test scenario
        String newItem = "Banana";
        
        // ACT: Execute the specific behavior or method being tested
        cart.addItem(newItem);
        int finalItemCount = cart.getItemCount();
        
        // ASSERT: Verify that the action produced the expected result
        assertEquals("Cart should have 2 items after adding one", 2, finalItemCount);
    }
    
    @Test
    public void testInitialState() {
        // ARRANGE: Handled automatically by the @Before setUp() method
        
        // ACT: Retrieve the current state
        int currentItemCount = cart.getItemCount();
        
        // ASSERT: Verify the setup state is intact
        assertEquals("Cart should start with exactly 1 item", 1, currentItemCount);
    }
}