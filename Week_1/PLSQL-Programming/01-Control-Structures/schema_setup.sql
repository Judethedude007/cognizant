-- Schema setup for PL/SQL Exercise 1 - Control Structures

DROP TABLE Loans;
DROP TABLE Customers;

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER(12,2),
    IsVIP VARCHAR2(5)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER(5,2),
    DueDate DATE,
    CONSTRAINT fk_customer
        FOREIGN KEY (CustomerID)
        REFERENCES Customers(CustomerID)
);

INSERT INTO Customers VALUES (1, 'John Mathew', 65, 15000, 'FALSE');
INSERT INTO Customers VALUES (2, 'Sarah Thomas', 45, 8000, 'FALSE');
INSERT INTO Customers VALUES (3, 'David George', 70, 12000, 'FALSE');
INSERT INTO Customers VALUES (4, 'Anita Joseph', 30, 5000, 'FALSE');

INSERT INTO Loans VALUES (101, 1, 8.5, SYSDATE + 10);
INSERT INTO Loans VALUES (102, 2, 9.0, SYSDATE + 40);
INSERT INTO Loans VALUES (103, 3, 7.5, SYSDATE + 20);
INSERT INTO Loans VALUES (104, 4, 10.0, SYSDATE + 5);

COMMIT;

SELECT * FROM Customers;
SELECT * FROM Loans;
