-- Scenario 1:
-- Apply a 1% discount to loan interest rates for customers above 60 years old.

BEGIN
    FOR customer_record IN (
        SELECT c.CustomerID, c.Name, c.Age, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
    )
    LOOP
        IF customer_record.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = customer_record.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Applied 1% discount for customer: ' ||
                customer_record.Name ||
                ', Loan ID: ' ||
                customer_record.LoanID
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/

SELECT * FROM Loans;
