package exercise4;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class calculator_fixture_test {

    calculator c;

    @Before
    public void setUp() {
        c = new calculator();
        System.out.println("Setup Executed");
    }

    @After
    public void tearDown() {
        System.out.println("Teardown Executed");
    }

    @Test
    public void testAdd() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = c.add(a, b);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testSub() {

        // Arrange
        int a = 15;
        int b = 5;

        // Act
        int result = c.sub(a, b);

        // Assert
        assertEquals(10, result);
    }
}