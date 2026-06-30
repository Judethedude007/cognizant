SET SERVEROUTPUT ON SIZE UNLIMITED;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE UPPER(Department) = UPPER(p_department);

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employee(s) in ' || p_department || ' received a ' || p_bonus_percentage || '% bonus.');
    END IF;

    COMMIT;
END;
/

SHOW ERRORS PROCEDURE UpdateEmployeeBonus;

PROMPT Before running UpdateEmployeeBonus
SELECT EmployeeID, Name, Department, Salary
FROM Employees
ORDER BY EmployeeID;

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

PROMPT After running UpdateEmployeeBonus
SELECT EmployeeID, Name, Department, Salary
FROM Employees
ORDER BY EmployeeID;
