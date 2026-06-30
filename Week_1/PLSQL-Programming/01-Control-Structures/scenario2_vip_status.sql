-- Scenario 2:
-- Set IsVIP to TRUE for customers with balance greater than 10000.

BEGIN
    FOR customer_record IN (
        SELECT CustomerID, Name, Balance
        FROM Customers
    )
    LOOP
        IF customer_record.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_record.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer promoted to VIP: ' ||
                customer_record.Name
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/

SELECT * FROM Customers;
