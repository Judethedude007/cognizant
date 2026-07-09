package com.cognizant.slf4jlogging;

public class LoggingDemoRunner {

    public static void main(String[] args) {
        System.out.println("Running Exercise 1 - Error and Warning Logging");
        LoggingExample.logErrorAndWarning();

        System.out.println("Running Exercise 2 - Parameterized Logging");
        ParameterizedLoggingExample.logUserAction("Jude", 101, "login");

        System.out.println("Running Exercise 3 - Different Appenders");
        AppenderLoggingExample.logWithDifferentAppenders();

        System.out.println("SLF4J logging demo completed.");
    }
}
