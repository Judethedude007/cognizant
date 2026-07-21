package com.cognizant.ormlearn;

import com.cognizant.ormlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        LOGGER.info("Start");

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        testGetAverageSalary();

        LOGGER.info("End");
    }

    private static void testGetAverageSalary() {
        LOGGER.info("Start - get average salary using HQL");

        int departmentId = 1;
        double averageSalary = employeeService.getAverageSalary(departmentId);

        LOGGER.debug("Department ID: {}", departmentId);
        LOGGER.debug("Average salary: {}", averageSalary);

        LOGGER.info("End - get average salary using HQL");
    }
}
