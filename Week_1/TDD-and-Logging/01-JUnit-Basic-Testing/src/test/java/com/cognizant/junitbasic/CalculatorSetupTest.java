package com.cognizant.junitbasic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorSetupTest {

    @Test
    public void testJUnitSetupWithAddition() {
        Calculator calculator = new Calculator();

        int result = calculator.add(2, 3);

        assertEquals(5, result);
    }
}
