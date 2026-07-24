package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MyServiceTest { 
    
    // --- Exercise 1 ---
    @Test 
    public void testExternalApi() { 
        ExternalApi mockApi = mock(ExternalApi.class); 
        when(mockApi.getData()).thenReturn("Mock Data"); 
        MyService service = new MyService(mockApi); 
        String result = service.fetchData(); 
        assertEquals("Mock Data", result); 
    } 

    // --- Exercise 2 ---
    @Test 
    public void testVerifyInteraction() { 
        // 1. Create a mock object. 
        ExternalApi mockApi = mock(ExternalApi.class); 
        
        // 2. Initialize service and call the method. 
        MyService service = new MyService(mockApi); 
        service.fetchData(); 
        
        // 3. Verify the interaction.
        // This ensures that service.fetchData() actually triggered mockApi.getData() behind the scenes.
        verify(mockApi).getData(); 
    } 
}