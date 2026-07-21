---------------------------------------------------------
-- BANK MANAGEMENT DATABASE SETUP
---------------------------------------------------------

CREATE TABLE Customer_Info (
    Cust_ID NUMBER PRIMARY KEY,
    Cust_Name VARCHAR2(100),
    Birth_Date DATE,
    Account_Balance NUMBER,
    Updated_On DATE
);


CREATE TABLE Bank_Accounts (
    Acc_ID NUMBER PRIMARY KEY,
    Cust_ID NUMBER,
    Acc_Category VARCHAR2(30),
    Current_Balance NUMBER,
    Modified_Date DATE,
    FOREIGN KEY(Cust_ID) REFERENCES Customer_Info(Cust_ID)
);


CREATE TABLE Bank_Transactions (
    Trans_ID NUMBER PRIMARY KEY,
    Acc_ID NUMBER,
    Trans_Date DATE,
    Amount NUMBER,
    Trans_Type VARCHAR2(20),
    FOREIGN KEY(Acc_ID) REFERENCES Bank_Accounts(Acc_ID)
);


CREATE TABLE Customer_Loans (
    Loan_No NUMBER PRIMARY KEY,
    Cust_ID NUMBER,
    Amount NUMBER,
    Rate NUMBER,
    Loan_Start DATE,
    Loan_End DATE,
    FOREIGN KEY(Cust_ID) REFERENCES Customer_Info(Cust_ID)
);


CREATE TABLE Staff_Details (
    Staff_ID NUMBER PRIMARY KEY,
    Staff_Name VARCHAR2(100),
    Role_Name VARCHAR2(50),
    Monthly_Salary NUMBER,
    Section_Name VARCHAR2(50),
    Joining_Date DATE
);



---------------------------------------------------------
-- INSERTING CUSTOMER RECORDS
---------------------------------------------------------

INSERT INTO Customer_Info
VALUES
(11,'Arjun Mehta',
TO_DATE('1958-11-25','YYYY-MM-DD'),
25000,
SYSDATE);


INSERT INTO Customer_Info
VALUES
(12,'Kavita Rao',
TO_DATE('1988-06-12','YYYY-MM-DD'),
18000,
SYSDATE);



---------------------------------------------------------
-- ACCOUNT INFORMATION
---------------------------------------------------------

INSERT INTO Bank_Accounts
VALUES
(501,11,'Savings',25000,SYSDATE);


INSERT INTO Bank_Accounts
VALUES
(502,12,'Salary',18000,SYSDATE);



---------------------------------------------------------
-- TRANSACTION HISTORY
---------------------------------------------------------

INSERT INTO Bank_Transactions
VALUES
(701,501,SYSDATE,3000,'CREDIT');


INSERT INTO Bank_Transactions
VALUES
(702,502,SYSDATE,1500,'DEBIT');



---------------------------------------------------------
-- LOAN DETAILS
---------------------------------------------------------

INSERT INTO Customer_Loans
VALUES
(901,11,75000,6.5,SYSDATE,ADD_MONTHS(SYSDATE,18));


INSERT INTO Customer_Loans
VALUES
(902,12,40000,7.5,SYSDATE,SYSDATE+15);



---------------------------------------------------------
-- EMPLOYEE RECORDS
---------------------------------------------------------

INSERT INTO Staff_Details
VALUES
(301,'Rohan Patel','Supervisor',80000,
'Operations',
TO_DATE('2016-09-20','YYYY-MM-DD'));


INSERT INTO Staff_Details
VALUES
(302,'Meera Joshi','Analyst',55000,
'Accounts',
TO_DATE('2021-01-15','YYYY-MM-DD'));



COMMIT;



---------------------------------------------------------
-- VIEWING DATA
---------------------------------------------------------

SELECT * FROM Customer_Info;
SELECT * FROM Bank_Accounts;
SELECT * FROM Bank_Transactions;
SELECT * FROM Customer_Loans;
SELECT * FROM Staff_Details;



---------------------------------------------------------

SET SERVEROUTPUT ON;



ALTER TABLE Customer_Info ADD VIP_Status CHAR(1);



---------------------------------------------------------
-- TASK 1:
-- Senior customers get reduced loan interest
---------------------------------------------------------

CREATE OR REPLACE PROCEDURE Senior_Customer_Benefit
IS

CURSOR customer_details IS
SELECT Cust_ID, Birth_Date
FROM Customer_Info;

years_old NUMBER;


BEGIN


FOR data IN customer_details
LOOP

years_old :=
MONTHS_BETWEEN(SYSDATE,data.Birth_Date)/12;


IF years_old > 60 THEN


UPDATE Customer_Loans
SET Rate = Rate - (Rate*0.01)
WHERE Cust_ID=data.Cust_ID;


DBMS_OUTPUT.PUT_LINE(
'Special interest benefit given to customer '
||data.Cust_ID);


END IF;


END LOOP;


END Senior_Customer_Benefit;
/




---------------------------------------------------------
-- TASK 2:
-- Update VIP customers based on account balance
---------------------------------------------------------

CREATE OR REPLACE PROCEDURE Update_VIP_Status
IS


CURSOR balance_check IS
SELECT Cust_ID,Current_Balance
FROM Bank_Accounts;


BEGIN


FOR account IN balance_check
LOOP


IF account.Current_Balance > 10000 THEN


UPDATE Customer_Info
SET VIP_Status='Y'
WHERE Cust_ID=account.Cust_ID;


DBMS_OUTPUT.PUT_LINE(
'VIP category assigned to customer '
||account.Cust_ID);


ELSE


UPDATE Customer_Info
SET VIP_Status='N'
WHERE Cust_ID=account.Cust_ID;


END IF;


END LOOP;


END Update_VIP_Status;
/




---------------------------------------------------------
-- TASK 3:
-- Display upcoming loan payment alerts
---------------------------------------------------------

CREATE OR REPLACE PROCEDURE Upcoming_Loan_Alert
IS


CURSOR loan_details IS
SELECT Cust_ID,Loan_End
FROM Customer_Loans
WHERE Loan_End BETWEEN SYSDATE AND SYSDATE+30;


BEGIN


FOR loan IN loan_details
LOOP


DBMS_OUTPUT.PUT_LINE(
'Payment reminder for customer '
||loan.Cust_ID||
' before '
||TO_CHAR(loan.Loan_End,'DD-MON-YYYY'));


END LOOP;


END Upcoming_Loan_Alert;
/




---------------------------------------------------------
-- RUNNING ALL TASKS
---------------------------------------------------------

BEGIN

DBMS_OUTPUT.PUT_LINE(
'Running senior customer interest update');

Senior_Customer_Benefit;

END;
/



BEGIN

DBMS_OUTPUT.PUT_LINE(
'Checking VIP eligibility');

Update_VIP_Status;

END;
/



BEGIN

DBMS_OUTPUT.PUT_LINE(
'Generating loan due notifications');

Upcoming_Loan_Alert;

END;
/