SET SERVEROUTPUT ON;

-- ====================================================================
-- DATABASE SCHEMA SETUP (TABLES CREATION)
-- ====================================================================

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- ====================================================================
-- DUMMY DATA INSERTION (FRESH INDIAN EXAMPLES)
-- ====================================================================

-- Customers
INSERT INTO Customers VALUES (101, 'Dharmpal Singh', TO_DATE('1975-04-12', 'YYYY-MM-DD'), 50000, SYSDATE);
INSERT INTO Customers VALUES (102, 'Sunita Sharma', TO_DATE('1988-08-24', 'YYYY-MM-DD'), 75000, SYSDATE);
INSERT INTO Customers VALUES (103, 'Rajesh Kumar', TO_DATE('1995-12-05', 'YYYY-MM-DD'), 20000, SYSDATE);

-- Accounts 
INSERT INTO Accounts VALUES (501, 101, 'Savings', 50000, SYSDATE);
INSERT INTO Accounts VALUES (502, 102, 'Savings', 75000, SYSDATE);
INSERT INTO Accounts VALUES (503, 103, 'Checking', 20000, SYSDATE);

-- Transactions
INSERT INTO Transactions VALUES (901, 501, SYSDATE, 5000, 'Deposit');
INSERT INTO Transactions VALUES (902, 503, SYSDATE, 2000, 'Withdrawal');

-- Loans
INSERT INTO Loans VALUES (401, 101, 200000, 8.5, SYSDATE, ADD_MONTHS(SYSDATE, 36));

-- Employees
INSERT INTO Employees VALUES (1, 'Amit Patel', 'Analyst', 60000, 'IT', TO_DATE('2021-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Meena Verma', 'Manager', 90000, 'HR', TO_DATE('2018-03-20', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (3, 'Vikram Malhotra', 'Developer', 65000, 'IT', TO_DATE('2022-01-10', 'YYYY-MM-DD'));

COMMIT;

-- Display Initial State Tables
SELECT * FROM Customers;
SELECT * FROM Accounts;
SELECT * FROM Transactions;
SELECT * FROM Loans;
SELECT * FROM Employees;

-- ====================================================================
-- STORED PROCEDURES DEVELOPMENT
-- ====================================================================

-- SCENARIO - 1: Apply 1% Monthly Interest to Savings Accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    CURSOR cur IS 
        SELECT AccountID, Balance 
        FROM Accounts 
        WHERE AccountType = 'Savings';
    v_interest NUMBER;
BEGIN
    FOR acc_rec IN cur LOOP
        v_interest := acc_rec.Balance * 0.01;
        UPDATE Accounts 
        SET Balance = Balance + v_interest,
            LastModified = SYSDATE
        WHERE AccountID = acc_rec.AccountID;
        DBMS_OUTPUT.PUT_LINE('AccountID: ' || acc_rec.AccountID || ' interest applied. Added: ' || v_interest);
    END LOOP;
END ProcessMonthlyInterest;
/

-- SCENARIO - 2: Update Employee Salary with Bonus Percentage by Department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
) IS
    CURSOR cur IS 
        SELECT EmployeeID, Salary 
        FROM Employees 
        WHERE Department = p_department;
BEGIN
    FOR emp_rec IN cur LOOP
        UPDATE Employees
        SET Salary = Salary + (Salary * (p_bonus_percent / 100))
        WHERE EmployeeID = emp_rec.EmployeeID;
        DBMS_OUTPUT.PUT_LINE('EmployeeID: ' || emp_rec.EmployeeID || ' salary updated with ' || p_bonus_percent || '% bonus.');
    END LOOP;
END UpdateEmployeeBonus;
/

-- SCENARIO - 3: Funds Transfer Between Accounts with Sufficiency Verification
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_acc IN NUMBER,
    p_dest_acc IN NUMBER,
    p_amount IN NUMBER
) IS
    v_source_balance NUMBER;
BEGIN
    SELECT Balance INTO v_source_balance FROM Accounts WHERE AccountID = p_source_acc;
    
    IF v_source_balance >= p_amount THEN
        UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE WHERE AccountID = p_source_acc;
        UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE WHERE AccountID = p_dest_acc;
        DBMS_OUTPUT.PUT_LINE('Successfully transferred ' || p_amount || ' from Account ' || p_source_acc || ' to ' || p_dest_acc);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Account ' || p_source_acc || ' has insufficient balance.');
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Account IDs not found.');
END TransferFunds;
/

-- ====================================================================
-- EXECUTION AND DRIVER BLOCKS
-- ====================================================================

BEGIN
    DBMS_OUTPUT.PUT_LINE('SCENARIO - 1: Processing monthly interest for all savings accounts');
    ProcessMonthlyInterest;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('SCENARIO - 2: Implementing bonus scheme for IT department employees');
    UpdateEmployeeBonus('IT', 10);
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('SCENARIO - 3: Transferring funds between customer accounts');
    -- Case A: Valid Fund Transfer Execution
    TransferFunds(501, 502, 10000);
    -- Case B: Insufficient Fund Transfer Execution
    TransferFunds(503, 501, 35000);
END;
/
