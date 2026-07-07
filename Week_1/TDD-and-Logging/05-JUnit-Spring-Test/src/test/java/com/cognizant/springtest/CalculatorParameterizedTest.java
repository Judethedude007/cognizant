package com.cognizant.springtest;

import com.cognizant.springtest.service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 5, 10",
            "10, 20, 30",
            "-1, 1, 0"
    })
    public void testAddWithMultipleInputs(int firstNumber, int secondNumber, int expectedResult) {
        CalculatorService calculatorService = new CalculatorService();

        int result = calculatorService.add(firstNumber, secondNumber);

        assertEquals(expectedResult, result);
    }
}
