package com.cognizant.slf4jlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        logUserAction("Jude", 101, "login");
    }

    public static void logUserAction(String userName, int userId, String action) {
        logger.info("User {} with id {} performed action {}", userName, userId, action);
        logger.debug("Parameterized debug log created for user {}", userName);
    }
}
