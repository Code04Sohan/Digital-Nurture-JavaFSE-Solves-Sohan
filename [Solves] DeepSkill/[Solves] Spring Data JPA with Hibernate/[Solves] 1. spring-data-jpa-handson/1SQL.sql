-- 1. Create Schema
CREATE SCHEMA ormlearn;
USE ormlearn;

-- 2. Create Table
CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY, 
    co_name VARCHAR(50)
);

-- 3. Insert Records
INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');

-- 4. Verify your records
SELECT * FROM country;
