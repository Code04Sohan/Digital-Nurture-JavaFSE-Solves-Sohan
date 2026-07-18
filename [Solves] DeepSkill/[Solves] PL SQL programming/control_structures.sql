ALTER TABLE Customers ADD COLUMN IsVIP TEXT DEFAULT 'FALSE';

-- ============================================================================
-- SCENARIO 1: Apply 1% interest discount for customers over 60 years old
-- ============================================================================

UPDATE Loans
SET InterestRate = InterestRate - 1
WHERE CustomerID IN (
    SELECT CustomerID 
    FROM Customers 
    WHERE (strftime('%Y', 'now') - strftime('%Y', DOB)) > 60
);


-- ============================================================================
-- SCENARIO 2: Promote customers to VIP status based on balance (> $10,000)
-- ============================================================================

UPDATE Customers
SET IsVIP = CASE 
    WHEN Balance > 10000 THEN 'TRUE'
    ELSE 'FALSE'
END;


-- ============================================================================
-- SCENARIO 3: Send reminders for loans due within the next 30 days
-- ============================================================================

SELECT 
    'REMINDER: Customer ' || c.Name || 
    ' has a loan (ID: ' || l.LoanID || 
    ') of $' || l.LoanAmount || 
    ' due on ' || l.EndDate || '.' AS ReminderMessage
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
WHERE l.EndDate BETWEEN date('now') AND date('now', '+30 days');
