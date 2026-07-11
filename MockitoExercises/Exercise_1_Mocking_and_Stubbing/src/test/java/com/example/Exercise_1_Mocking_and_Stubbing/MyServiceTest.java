package com.example.Exercise_1_Mocking_and_Stubbing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testExternalApi() {

        ExternalAPI mockApi = mock(ExternalAPI.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchData();

        System.out.println(result);

        assertEquals("Mock Data", result);
    }
}
