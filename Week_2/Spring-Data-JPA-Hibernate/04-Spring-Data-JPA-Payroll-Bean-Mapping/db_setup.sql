CREATE SCHEMA IF NOT EXISTS ormlearn;

USE ormlearn;

DROP TABLE IF EXISTS employee_skill;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS department;

CREATE TABLE department (
    dp_id INT NOT NULL AUTO_INCREMENT,
    dp_name VARCHAR(45),
    PRIMARY KEY (dp_id)
);

CREATE TABLE skill (
    sk_id INT NOT NULL AUTO_INCREMENT,
    sk_name VARCHAR(45),
    PRIMARY KEY (sk_id)
);

CREATE TABLE employee (
    em_id INT NOT NULL AUTO_INCREMENT,
    em_name VARCHAR(45),
    em_salary DECIMAL(10,2),
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    PRIMARY KEY (em_id),
    CONSTRAINT fk_employee_department
        FOREIGN KEY (em_dp_id)
        REFERENCES department(dp_id)
);

CREATE TABLE employee_skill (
    es_id INT NOT NULL AUTO_INCREMENT,
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_id),
    CONSTRAINT fk_employee_skill_employee
        FOREIGN KEY (es_em_id)
        REFERENCES employee(em_id),
    CONSTRAINT fk_employee_skill_skill
        FOREIGN KEY (es_sk_id)
        REFERENCES skill(sk_id)
);

INSERT INTO department (dp_name) VALUES ('Technology');
INSERT INTO department (dp_name) VALUES ('Human Resources');
INSERT INTO department (dp_name) VALUES ('Finance');

INSERT INTO skill (sk_name) VALUES ('Java');
INSERT INTO skill (sk_name) VALUES ('Spring Boot');
INSERT INTO skill (sk_name) VALUES ('SQL');
INSERT INTO skill (sk_name) VALUES ('Hibernate');

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('John', 80000.00, true, '1990-05-15', 1);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('Jane', 65000.00, false, '1992-08-20', 2);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('Rahul', 72000.00, true, '1991-03-12', 1);

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 4);

SELECT * FROM department;
SELECT * FROM skill;
SELECT * FROM employee;
SELECT * FROM employee_skill;
