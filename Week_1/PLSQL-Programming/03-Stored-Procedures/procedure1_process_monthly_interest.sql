SET SERVEROUTPUT ON SIZE UNLIMITED;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE UPPER(AccountType) = 'SAVINGS';

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' savings account(s) updated with 1% monthly interest.');

    COMMIT;
END;
/

SHOW ERRORS PROCEDURE ProcessMonthlyInterest;

PROMPT Before running ProcessMonthlyInterest
SELECT AccountID, CustomerID, AccountType, Balance
FROM Accounts
ORDER BY AccountID;

BEGIN
    ProcessMonthlyInterest;
END;
/

PROMPT After running ProcessMonthlyInterest
SELECT AccountID, CustomerID, AccountType, Balance
FROM Accounts
ORDER BY AccountID;
