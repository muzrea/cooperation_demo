CREATE DATABASE examination_management_sys DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
USE examination_management_sys;

CREATE TABLE user (
	id INT AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET= utf8;

CREATE TABLE role (
	id INT AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8; 

CREATE TABLE profile (
	id VARCHAR(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE role_profile (
	id INT AUTO_INCREMENT,
    role_id INT,
    profile_id VARCHAR(10),
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE subject (
	id INT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE subject_teacher (
	id INT AUTO_INCREMENT,
    subject_id INT NOT NULL,
    teacher_id INT NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE score (
	id INT AUTO_INCREMENT,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    score DOUBLE NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE student (
	id INT,
    name VARCHAR(20) NOT NULL,
    sex CHAR(1) NOT NULL,
    age INT NOT NULL,
    major VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE teacher (
	id INT,
    name VARCHAR(20) NOT NULL,
    sex CHAR(1) NOT NULL,
    age INT NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;




