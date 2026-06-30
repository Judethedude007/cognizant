SET SERVEROUTPUT ON SIZE UNLIMITED;

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_target_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_source_balance NUMBER(12,2);
    v_target_count NUMBER;
BEGIN
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
    END IF;

    SELECT Balance
    INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_source_account_id
    FOR UPDATE;

    SELECT COUNT(*)
    INTO v_target_count
    FROM Accounts
    WHERE AccountID = p_target_account_id;

    IF v_target_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Target account does not exist.');
    END IF;

    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20003, 'Insufficient balance in source account.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_source_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_target_account_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from account ' || p_source_account_id || ' to account ' || p_target_account_id || '.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Source account does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

SHOW ERRORS PROCEDURE TransferFunds;

PROMPT Before running TransferFunds
SELECT AccountID, CustomerID, AccountType, Balance
FROM Accounts
ORDER BY AccountID;

BEGIN
    TransferFunds(1, 2, 500);
END;
/

PROMPT After running TransferFunds
SELECT AccountID, CustomerID, AccountType, Balance
FROM Accounts
ORDER BY AccountID;
