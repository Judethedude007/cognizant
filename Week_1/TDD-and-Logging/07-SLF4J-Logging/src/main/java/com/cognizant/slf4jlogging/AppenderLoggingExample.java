package com.cognizant.slf4jlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderLoggingExample.class);

    public static void main(String[] args) {
        logWithDifferentAppenders();
    }

    public static void logWithDifferentAppenders() {
        logger.debug("This debug message is written using configured appenders");
        logger.info("This info message is written to console and file");
        logger.warn("This warning message is written to console and file");
        logger.error("This error message is written to console and file");
    }
}
