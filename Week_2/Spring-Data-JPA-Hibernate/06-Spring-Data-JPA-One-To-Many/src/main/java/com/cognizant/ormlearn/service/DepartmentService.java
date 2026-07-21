package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public Department get(int id) {
        LOGGER.info("Start");
        Department department = departmentRepository.findById(id).orElseThrow();
        LOGGER.info("End");
        return department;
    }

    @Transactional
    public Department save(Department department) {
        LOGGER.info("Start");
        Department savedDepartment = departmentRepository.save(department);
        LOGGER.info("End");
        return savedDepartment;
    }
}
