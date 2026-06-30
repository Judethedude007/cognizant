-- Scenario 3:
-- Print reminder messages for loans due within the next 30 days.

BEGIN
    FOR loan_record IN (
        SELECT c.Name, l.LoanID, l.DueDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID ' ||
            loan_record.LoanID ||
            ' for customer ' ||
            loan_record.Name ||
            ' is due on ' ||
            TO_CHAR(loan_record.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
