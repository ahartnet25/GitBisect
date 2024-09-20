package com.andy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(1,4));
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(90, calculator.subtract(100,10));
    }

    @Test
    void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(100, calculator.multiply(10,10));
    }

    @Test
    void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.divide(10,2));
    }
    

}
