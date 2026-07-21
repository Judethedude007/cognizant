package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        LOGGER.info("Start");

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        testGetAllPermanentEmployees();

        LOGGER.info("End");
    }

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start - get all permanent employees using HQL");

        List<Employee> employees = employeeService.getAllPermanentEmployees();

        LOGGER.debug("Permanent Employees: {}", employees);

        employees.forEach(employee -> {
            LOGGER.debug("Employee: {}", employee);
            LOGGER.debug("Department: {}", employee.getDepartment());
            LOGGER.debug("Skills: {}", employee.getSkillList());
        });

        LOGGER.debug("Permanent employee count: {}", employees.size());

        LOGGER.info("End - get all permanent employees using HQL");
    }
}
