package com.cognizant.slf4jlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logErrorAndWarning();
    }

    public static void logErrorAndWarning() {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
