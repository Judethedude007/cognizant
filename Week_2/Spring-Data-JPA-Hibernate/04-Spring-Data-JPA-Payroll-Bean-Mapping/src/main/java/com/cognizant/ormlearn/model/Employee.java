package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "em_id")
    private Integer id;

    @Column(name = "em_name")
    private String name;

    @Column(name = "em_salary")
    private Double salary;

    @Column(name = "em_permanent")
    private Boolean permanent;

    @Temporal(TemporalType.DATE)
    @Column(name = "em_date_of_birth")
    private Date dateOfBirth;

    @Column(name = "em_dp_id")
    private Integer departmentId;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Boolean getPermanent() {
        return permanent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id
                + ", name='" + name + "'"
                + ", salary=" + salary
                + ", permanent=" + permanent
                + ", dateOfBirth=" + dateOfBirth
                + ", departmentId=" + departmentId
                + "}";
    }
}
