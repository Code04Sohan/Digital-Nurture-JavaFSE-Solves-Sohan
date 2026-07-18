CREATE TABLE Customers (
    CustomerID INTEGER PRIMARY KEY,
    Name TEXT,
    DOB TEXT,           
    Balance REAL,       
    LastModified TEXT
);

CREATE TABLE Accounts (
    AccountID INTEGER PRIMARY KEY,
    CustomerID INTEGER,
    AccountType TEXT,
    Balance REAL,
    LastModified TEXT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID INTEGER PRIMARY KEY,
    AccountID INTEGER,
    TransactionDate TEXT,
    Amount REAL,
    TransactionType TEXT,
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID INTEGER PRIMARY KEY,
    CustomerID INTEGER,
    LoanAmount REAL,
    InterestRate REAL,
    StartDate TEXT,
    EndDate TEXT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID INTEGER PRIMARY KEY,
    Name TEXT,
    Position TEXT,
    Salary REAL,
    Department TEXT,
    HireDate TEXT
);


INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', '1985-05-15', 1000, datetime('now'));

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', '1990-07-20', 1500, datetime('now'));

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, datetime('now'));

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, datetime('now'));

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, datetime('now'), 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, datetime('now'), 300, 'Withdrawal');

-- SQLite alternative to Oracle's ADD_MONTHS(SYSDATE, 60):
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, date('now'), date('now', '+60 months'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', '2015-06-15');

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', '2017-03-20');
