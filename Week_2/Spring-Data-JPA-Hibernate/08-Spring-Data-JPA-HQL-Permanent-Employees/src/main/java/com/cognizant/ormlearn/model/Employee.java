package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "em_dp_id")
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_skill",
            joinColumns = @JoinColumn(name = "es_em_id"),
            inverseJoinColumns = @JoinColumn(name = "es_sk_id")
    )
    private Set<Skill> skillList;

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

    public Department getDepartment() {
        return department;
    }

    public Set<Skill> getSkillList() {
        return skillList;
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

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSkillList(Set<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        Integer departmentId = department != null ? department.getId() : null;
        String departmentName = department != null ? department.getName() : null;

        return "Employee{id=" + id
                + ", name='" + name + "'"
                + ", salary=" + salary
                + ", permanent=" + permanent
                + ", dateOfBirth=" + dateOfBirth
                + ", departmentId=" + departmentId
                + ", departmentName='" + departmentName + "'"
                + "}";
    }
}
