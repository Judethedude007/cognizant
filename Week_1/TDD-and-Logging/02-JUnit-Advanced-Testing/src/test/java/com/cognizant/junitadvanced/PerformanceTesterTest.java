package com.cognizant.junitadvanced;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@Tag("performance")
public class PerformanceTesterTest {

    @Test
    public void testPerformanceTimeout() {
        PerformanceTester performanceTester = new PerformanceTester();

        assertTimeout(Duration.ofMillis(100), () -> {
            String result = performanceTester.performTask();

            assertEquals("Task completed", result);
        });
    }
}
