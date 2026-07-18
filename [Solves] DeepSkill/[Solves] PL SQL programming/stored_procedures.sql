-- ============================================================================
-- SCENARIO 1: Process monthly interest for all savings accounts
-- ============================================================================
UPDATE Accounts
SET 
    Balance = Balance * 1.01,
    LastModified = datetime('now')
WHERE AccountType = 'Savings';


-- ============================================================================
-- SCENARIO 2: Update employee salaries with a dynamic bonus percentage
-- ============================================================================
UPDATE Employees
SET Salary = Salary * (1 + 0.05)
WHERE Department = 'IT';


-- ============================================================================
-- SCENARIO 3: Transfer funds between accounts with a balance safety check
-- ============================================================================

UPDATE Accounts
SET 
    Balance = Balance - 250,
    LastModified = datetime('now')
WHERE AccountID = 1 
  AND Balance >= 250;

UPDATE Accounts
SET 
    Balance = Balance + 250,
    LastModified = datetime('now')
WHERE AccountID = 2 
  AND (SELECT Balance FROM Accounts WHERE AccountID = 1) >= 0;
