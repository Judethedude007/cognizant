package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
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
        testGetEmployee();
        testAddSkillToEmployee();
    }

    private void testGetEmployee() {
        LOGGER.info("Start - get employee with department and skills");

        Employee employee = employeeService.get(1);

        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkillList());
        LOGGER.debug("Skill count: {}", employee.getSkillList().size());

        LOGGER.info("End - get employee with department and skills");
    }

    private void testAddSkillToEmployee() {
        LOGGER.info("Start - add skill to employee");

        Employee employee = employeeService.get(2);
        Skill skill = skillService.get(1);

        LOGGER.debug("Employee before adding skill: {}", employee);
        LOGGER.debug("Skills before adding skill: {}", employee.getSkillList());

        employee.getSkillList().add(skill);

        Employee savedEmployee = employeeService.save(employee);

        LOGGER.debug("Employee after adding skill: {}", savedEmployee);
        LOGGER.debug("Skills after adding skill: {}", savedEmployee.getSkillList());
        LOGGER.debug("Skill count after adding skill: {}", savedEmployee.getSkillList().size());

        LOGGER.info("End - add skill to employee");
    }
}
