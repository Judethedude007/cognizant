package com.cognizant.junitadvanced;

public class PerformanceTester {

    public String performTask() {
        long total = 0;

        for (int i = 0; i < 1000; i++) {
            total += i;
        }

        return "Task completed";
    }
}
