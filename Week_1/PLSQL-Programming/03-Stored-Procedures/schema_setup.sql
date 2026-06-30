SET SERVEROUTPUT ON SIZE UNLIMITED;

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;
/

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Balance NUMBER(12,2)
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER(12,2),
    CONSTRAINT fk_accounts_customers
        FOREIGN KEY (CustomerID)
        REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER(12,2)
);

INSERT INTO Customers VALUES (1, 'John Mathew', 15000);
INSERT INTO Customers VALUES (2, 'Anita Sharma', 8000);
INSERT INTO Customers VALUES (3, 'David Joseph', 12000);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 10000);
INSERT INTO Accounts VALUES (2, 1, 'Current', 5000);
INSERT INTO Accounts VALUES (3, 2, 'Savings', 7000);
INSERT INTO Accounts VALUES (4, 3, 'Savings', 12000);

INSERT INTO Employees VALUES (101, 'Rahul Nair', 'IT', 50000);
INSERT INTO Employees VALUES (102, 'Priya Menon', 'IT', 60000);
INSERT INTO Employees VALUES (103, 'Arun Das', 'HR', 45000);
INSERT INTO Employees VALUES (104, 'Meera Iyer', 'Finance', 55000);

COMMIT;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Schema setup completed successfully.');
END;
/

SELECT * FROM Customers ORDER BY CustomerID;
SELECT * FROM Accounts ORDER BY AccountID;
SELECT * FROM Employees ORDER BY EmployeeID;
