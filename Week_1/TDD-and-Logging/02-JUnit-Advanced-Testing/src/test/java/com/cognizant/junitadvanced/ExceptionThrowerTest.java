package com.cognizant.junitadvanced;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("exception")
public class ExceptionThrowerTest {

    @Test
    public void testExpectedException() {
        ExceptionThrower exceptionThrower = new ExceptionThrower();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                exceptionThrower::throwException
        );

        assertEquals("Invalid operation", exception.getMessage());
    }
}
