package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final SkillRepository skillRepository;

    public OrmLearnApplication(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            SkillRepository skillRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.skillRepository = skillRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    @Override
    public void run(ApplicationArguments args) {
        testPayrollBeanMapping();
    }

    private void testPayrollBeanMapping() {
        LOGGER.info("Start - payroll bean mapping");

        List<Employee> employees = employeeRepository.findAll();
        List<Department> departments = departmentRepository.findAll();
        List<Skill> skills = skillRepository.findAll();

        LOGGER.debug("Employees: {}", employees);
        LOGGER.debug("Departments: {}", departments);
        LOGGER.debug("Skills: {}", skills);

        LOGGER.debug("Employee count: {}", employees.size());
        LOGGER.debug("Department count: {}", departments.size());
        LOGGER.debug("Skill count: {}", skills.size());

        LOGGER.info("End - payroll bean mapping");
    }
}
