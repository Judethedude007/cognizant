package com.cognizant.junitadvanced;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("ordered")
@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    private static List<String> executionOrder;

    @BeforeAll
    public static void setUp() {
        executionOrder = new ArrayList<>();
    }

    @Test
    @Order(1)
    public void testFirstStep() {
        executionOrder.add("first");

        assertEquals("first", executionOrder.get(0));
    }

    @Test
    @Order(2)
    public void testSecondStep() {
        executionOrder.add("second");

        assertEquals("second", executionOrder.get(1));
    }

    @Test
    @Order(3)
    public void testThirdStep() {
        executionOrder.add("third");

        assertEquals("third", executionOrder.get(2));
    }
}
