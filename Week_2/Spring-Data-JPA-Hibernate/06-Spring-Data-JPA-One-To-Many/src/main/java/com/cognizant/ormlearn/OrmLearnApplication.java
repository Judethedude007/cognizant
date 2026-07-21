package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final SkillService skillService;

    public OrmLearnApplication(
            EmployeeService employeeService,
            DepartmentService departmentService,
            SkillService skillService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.skillService = skillService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    @Override
    public void run(ApplicationArguments args) {
        testGetDepartment();
    }

    private void testGetDepartment() {
        LOGGER.info("Start - get department with employees");

        Department department = departmentService.get(1);

        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employees: {}", department.getEmployeeList());
        LOGGER.debug("Employee count in department: {}", department.getEmployeeList().size());

        LOGGER.info("End - get department with employees");
    }
}
