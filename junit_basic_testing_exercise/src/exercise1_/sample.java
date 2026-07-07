package exercise1_;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class sample {

    @Test
    public void testAddition() {

        int expected = 5;
        int actual = 2 + 3;

        System.out.println("Expected Value = " + expected);
        System.out.println("Actual Value = " + actual);

        assertEquals(expected, actual);

        System.out.println("Exercise 1 Passed Successfully");
    }
}