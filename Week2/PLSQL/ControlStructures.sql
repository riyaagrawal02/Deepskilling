-- Exercise 1 : Control Structures

-- Scenario 1
-- Apply 1% discount on loan interest rate
-- for customers above 60 years

BEGIN
    FOR rec IN (
        SELECT c.CustomerID, c.Age, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
    )
    LOOP
        IF rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- Scenario 2
-- Promote customers to VIP

BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance
        FROM Customers
    )
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/


-- Scenario 3
-- Print reminders for loans due in next 30 days

SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT c.CustomerName,l.LoanID,l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan '|| rec.LoanID|| ' for '|| rec.CustomerName|| ' is due on '|| TO_CHAR(rec.DueDate,'DD-MON-YYYY')
        );
    END LOOP;
END;
/

