DROP DATABASE IF EXISTS controleAluno;
CREATE DATABASE controleAluno;
USE controleAluno;

CREATE TABLE schedule (
	schedule_id INT NOT NULL AUTO_INCREMENT,
    schedule_start TIME NOT NULL,
    schedule_end TIME NOT NULL,
    schedule_period ENUM('matutino', 'vespertino', 'noturno') NOT NULL,
    PRIMARY KEY (schedule_id)
);

CREATE TABLE class (
	class_id INT NOT NULL AUTO_INCREMENT,
    class_acronym VARCHAR(20) NOT NULL,
    class_year YEAR NOT NULL,
    PRIMARY KEY (class_id)
);

CREATE TABLE student (
	student_id INT NOT NULL AUTO_INCREMENT,
    class_id INT NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    student_birthdate DATE NOT NULL,
    student_adult TINYINT(1) DEFAULT '0',
    student_license ENUM('total', 'parcial', 'negada') DEFAULT 'negada',
    PRIMARY KEY (student_id),
    FOREIGN KEY (class_id) REFERENCES class (class_id)
);

CREATE TABLE student_license (
	license_id INT NOT NULL,
    student_id INT NOT NULL,
    allowed_time TIME NOT NULL,
    PRIMARY KEY (license_id, student_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id)
);

CREATE TABLE guardian (
	guardian_id INT NOT NULL AUTO_INCREMENT,
    student_id INT NOT NULL,
    guardian_name VARCHAR(100) NOT NULL,
    guardian_birthdate DATE NOT NULL,
    PRIMARY KEY (guardian_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id)
);

CREATE TABLE timetable (
	timetable_day ENUM('segunda', 'terca', 'quarta', 'quinta', 'sexta') NOT NULL,
    schedule_id INT NOT NULL,
    class_id INT NOT NULL,
    PRIMARY KEY (timetable_day, schedule_id, class_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id),
    FOREIGN KEY (class_id) REFERENCES class (class_id)
);

CREATE TABLE report (
	report_id INT NOT NULL,
    student_id INT NOT NULL,
    report_date DATE NOT NULL,
    report_time TIME NOT NULL,
    guardian_id INT,
    report_reason TEXT,
    report_doc TEXT,
    PRIMARY KEY (report_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id),
    FOREIGN KEY (guardian_id) REFERENCES guardian (guardian_id)
);