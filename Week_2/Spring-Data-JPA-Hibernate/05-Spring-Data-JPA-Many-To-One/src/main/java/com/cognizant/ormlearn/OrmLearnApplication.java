package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

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
    public void run(ApplicationArguments args) throws Exception {
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
    }

    private void testGetEmployee() {
        LOGGER.info("Start - get employee with department");

        Employee employee = employeeService.get(1);

        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());

        LOGGER.info("End - get employee with department");
    }

    private void testAddEmployee() throws Exception {
        LOGGER.info("Start - add employee with department");

        Employee employee = new Employee();
        employee.setName("Mary");
        employee.setSalary(90000.00);
        employee.setPermanent(true);
        employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1994-04-10"));

        Department department = departmentService.get(1);
        employee.setDepartment(department);

        Employee savedEmployee = employeeService.save(employee);

        LOGGER.debug("Saved Employee: {}", savedEmployee);
        LOGGER.debug("Saved Employee Department: {}", savedEmployee.getDepartment());

        LOGGER.info("End - add employee with department");
    }

    private void testUpdateEmployee() {
        LOGGER.info("Start - update employee department");

        Employee employee = employeeService.get(2);
        Department department = departmentService.get(3);

        employee.setDepartment(department);

        Employee updatedEmployee = employeeService.save(employee);

        LOGGER.debug("Updated Employee: {}", updatedEmployee);
        LOGGER.debug("Updated Employee Department: {}", updatedEmployee.getDepartment());

        LOGGER.info("End - update employee department");
    }
}
