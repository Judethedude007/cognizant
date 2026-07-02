package com.cognizant.junitbasic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorAaaFixtureTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator.clear();
        calculator = null;
    }

    @Test
    public void testAdditionUsingAaaPattern() {
        int firstNumber = 10;
        int secondNumber = 5;

        int result = calculator.add(firstNumber, secondNumber);

        assertEquals(15, result);
    }

    @Test
    public void testSubtractionUsingAaaPattern() {
        int firstNumber = 10;
        int secondNumber = 5;

        int result = calculator.subtract(firstNumber, secondNumber);

        assertEquals(5, result);
    }

    @Test
    public void testMultiplicationUsingAaaPattern() {
        int firstNumber = 10;
        int secondNumber = 5;

        int result = calculator.multiply(firstNumber, secondNumber);

        assertEquals(50, result);
    }

    @Test
    public void testDivisionUsingAaaPattern() {
        int firstNumber = 10;
        int secondNumber = 5;

        int result = calculator.divide(firstNumber, secondNumber);

        assertEquals(2, result);
    }
}
