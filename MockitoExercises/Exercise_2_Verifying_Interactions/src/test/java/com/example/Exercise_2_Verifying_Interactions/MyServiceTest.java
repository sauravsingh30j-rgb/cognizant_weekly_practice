package com.example.Exercise_2_Verifying_Interactions;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Create mock object
        ExternalAPI mockApi = Mockito.mock(ExternalAPI.class);

        // Inject mock into service
        MyService service = new MyService(mockApi);

        // Call the method
        service.fetchData();

        // Verify interaction
        verify(mockApi).getData();

        // Console output
        System.out.println("Test Passed: getData() was called successfully.");
    }
}