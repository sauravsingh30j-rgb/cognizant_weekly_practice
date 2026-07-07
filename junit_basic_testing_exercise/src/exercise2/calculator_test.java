package exercise2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class calculator_test {

    calculator c = new calculator();

    @Test
    public void testAdd() {
        int result = c.add(5, 5);
        System.out.println("Addition Result = " + result);
        assertEquals(10, result);
        System.out.println("Addition Test Passed");
    }

    @Test
    public void testSub() {
        int result = c.sub(5, 3);
        System.out.println("Subtraction Result = " + result);
        assertEquals(2, result);
        System.out.println("Subtraction Test Passed");
    }

    @Test
    public void testMul() {
        int result = c.mul(4, 5);
        System.out.println("Multiplication Result = " + result);
        assertEquals(20, result);
        System.out.println("Multiplication Test Passed");
    }

    @Test
    public void testDiv() {
        int result = c.div(10, 2);
        System.out.println("Division Result = " + result);
        assertEquals(5, result);
        System.out.println("Division Test Passed");
    }
}