USE ormlearn;

-- 1. Create Tables
CREATE TABLE IF NOT EXISTS user (
    us_id INT AUTO_INCREMENT PRIMARY KEY,
    us_name VARCHAR(45),
    us_email VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS question (
    qt_id INT AUTO_INCREMENT PRIMARY KEY,
    qt_text VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS options (
    op_id INT AUTO_INCREMENT PRIMARY KEY,
    op_qt_id INT,
    op_score DOUBLE,
    op_text VARCHAR(100),
    FOREIGN KEY (op_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE IF NOT EXISTS attempt (
    at_id INT AUTO_INCREMENT PRIMARY KEY,
    at_date DATE,
    at_us_id INT,
    at_score DOUBLE,
    FOREIGN KEY (at_us_id) REFERENCES user(us_id)
);

CREATE TABLE IF NOT EXISTS attempt_question (
    aq_id INT AUTO_INCREMENT PRIMARY KEY,
    aq_at_id INT,
    aq_qt_id INT,
    FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    FOREIGN KEY (aq_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE IF NOT EXISTS attempt_option (
    ao_id INT AUTO_INCREMENT PRIMARY KEY,
    ao_op_id INT,
    ao_aq_id INT,
    ao_selected BIT,
    FOREIGN KEY (ao_op_id) REFERENCES options(op_id),
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id)
);

-- 2. Insert Master Data
INSERT INTO user (us_id, us_name, us_email) VALUES (1, 'Admin', 'admin@quiz.com');

INSERT INTO question (qt_id, qt_text) VALUES 
(1, 'What is the extension of the hyper text markup language file?'),
(2, 'What is the maximum level of heading tag can be used in a HTML page?'),
(3, 'The HTML document itself begins with <html> and ends </html>. State True of False'),
(4, 'Choose the right option to store text value value in a variable');

INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES 
(1, 1, 0.0, '.xhtm'), (2, 1, 0.0, '.ht'), (3, 1, 1.0, '.html'), (4, 1, 0.0, '.htmx'),
(5, 2, 0.0, '5'), (6, 2, 0.0, '3'), (7, 2, 0.0, '4'), (8, 2, 1.0, '6'),
(9, 3, 0.0, 'false'), (10, 3, 1.0, 'true'),
(11, 4, 0.5, '''John'''), (12, 4, 0.0, 'John'), (13, 4, 0.5, '"John"'), (14, 4, 0.0, '/John/');

-- 3. Insert Attempt Data (Simulating the output from the assignment)
INSERT INTO attempt (at_id, at_date, at_us_id, at_score) VALUES (1, '2026-07-20', 1, 2.5);

INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES 
(1, 1, 1), (2, 1, 2), (3, 1, 3), (4, 1, 4);

-- 1=selected, 0=not selected
INSERT INTO attempt_option (ao_op_id, ao_aq_id, ao_selected) VALUES 
(1, 1, 0), (2, 1, 0), (3, 1, 1), (4, 1, 0),    -- Q1: Chose .html (Correct)
(5, 2, 0), (6, 2, 1), (7, 2, 0), (8, 2, 0),    -- Q2: Chose 3 (Incorrect)
(9, 3, 0), (10, 3, 1),                         -- Q3: Chose true (Correct)
(11, 4, 1), (12, 4, 0), (13, 4, 0), (14, 4, 0);-- Q4: Chose 'John' (Partial)