package exercise3;

import static org.junit.Assert.*;
import org.junit.Test;

public class assertion_test {

    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(5, 2 + 3);
        System.out.println("assertEquals Passed");

        // Assert True
        assertTrue(5 > 3);
        System.out.println("assertTrue Passed");

        // Assert False
        assertFalse(5 < 3);
        System.out.println("assertFalse Passed");

        // Assert Null
        assertNull(null);
        System.out.println("assertNull Passed");

        // Assert Not Null
        assertNotNull(new Object());
        System.out.println("assertNotNull Passed");

        System.out.println("Exercise 3 Completed Successfully");
    }
}