CREATE TABLE IF NOT EXISTS ErrorLog (
    LogID INTEGER PRIMARY KEY AUTOINCREMENT,
    ScenarioText TEXT,
    ErrorMessage TEXT,
    LogTimestamp TEXT DEFAULT (datetime('now'))
);

ROLLBACK;

-- ============================================================================
-- SCENARIO 1: Handle exceptions during fund transfers between accounts
-- ============================================================================
BEGIN TRANSACTION;


INSERT INTO ErrorLog (ScenarioText, ErrorMessage)
SELECT 'Fund Transfer', 'Transaction Aborted: Account 1 has insufficient funds for $200 transfer.'
WHERE (SELECT Balance FROM Accounts WHERE AccountID = 1) < 200;


UPDATE Accounts 
SET Balance = Balance - 200, LastModified = datetime('now')
WHERE AccountID = 1 AND Balance >= 200;


UPDATE Accounts 
SET Balance = Balance + 200, LastModified = datetime('now')
WHERE AccountID = 2 AND changes() > 0;


COMMIT;


-- ============================================================================
-- SCENARIO 2: Manage errors when updating employee salaries
-- ============================================================================


INSERT INTO ErrorLog (ScenarioText, ErrorMessage)
SELECT 'Salary Update', 'Error: EmployeeID 99 does not exist.'
WHERE NOT EXISTS (SELECT 1 FROM Employees WHERE EmployeeID = 99);


UPDATE Employees
SET Salary = Salary * (1 + 0.10) -- Increases salary by 10%
WHERE EmployeeID = 99;


-- ============================================================================
-- SCENARIO 3: Ensure data integrity when adding a new customer
-- ============================================================================


INSERT INTO ErrorLog (ScenarioText, ErrorMessage)
SELECT 'Add Customer', 'Exception: CustomerID 1 already exists. Insertion blocked.'
WHERE EXISTS (SELECT 1 FROM Customers WHERE CustomerID = 1);


INSERT OR IGNORE INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (1, 'New Guy', '1995-01-01', 500, datetime('now'), 'FALSE');


-- ============================================================================
SELECT LogID, ScenarioText, ErrorMessage, LogTimestamp FROM ErrorLog;
-- ============================================================================