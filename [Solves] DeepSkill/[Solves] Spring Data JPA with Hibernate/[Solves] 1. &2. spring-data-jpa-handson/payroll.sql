USE ormlearn;

-- 1. Create Department Table
CREATE TABLE IF NOT EXISTS department (
    dp_id INT AUTO_INCREMENT,
    dp_name VARCHAR(45),
    PRIMARY KEY (dp_id)
);

-- 2. Create Skill Table
CREATE TABLE IF NOT EXISTS skill (
    sk_id INT AUTO_INCREMENT,
    sk_name VARCHAR(45),
    PRIMARY KEY (sk_id)
);

-- 3. Create Employee Table
CREATE TABLE IF NOT EXISTS employee (
    em_id INT AUTO_INCREMENT,
    em_name VARCHAR(45),
    em_salary DECIMAL(10,2),
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    PRIMARY KEY (em_id),
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

-- 4. Create Employee_Skill (Many-to-Many Join Table)
CREATE TABLE IF NOT EXISTS employee_skill (
    es_id INT AUTO_INCREMENT,
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

-- Optional: Insert some initial test data to query later
INSERT INTO department (dp_name) VALUES ('Engineering'), ('Human Resources');
INSERT INTO skill (sk_name) VALUES ('Java'), ('Spring Boot');