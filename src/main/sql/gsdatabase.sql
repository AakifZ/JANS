-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gradingsystem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gradingsystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gradingsystem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `gradingsystem` ;

-- -----------------------------------------------------
-- Table `gradingsystem`.`sysadmin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`sysadmin` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`sysadmin` (
                                                          `admin_ID` INT NOT NULL AUTO_INCREMENT,
                                                          `first_name` VARCHAR(45) NOT NULL,
                                                          `last_name` VARCHAR(45) NOT NULL,
                                                          `email` VARCHAR(45) NOT NULL,
                                                          PRIMARY KEY (`admin_ID`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`professor` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`professor` (
                                                           `professor_ID` INT NOT NULL AUTO_INCREMENT,
                                                           `first_name` VARCHAR(45) NOT NULL,
                                                           `last_name` VARCHAR(45) NOT NULL,
                                                           `email` VARCHAR(45) NOT NULL,
                                                           `phone` VARCHAR(10) NULL,
                                                           `sysAdmin` INT NULL,
                                                           PRIMARY KEY (`professor_ID`),
                                                           INDEX `sysAdmin_idx` (`sysAdmin` ASC) VISIBLE,
                                                           CONSTRAINT `profSysAdmin`
                                                               FOREIGN KEY (`sysAdmin`)
                                                                   REFERENCES `gradingsystem`.`sysadmin` (`admin_ID`)
                                                                   ON DELETE NO ACTION
                                                                   ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`course` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`course` (
                                                        `course_ID` INT NOT NULL AUTO_INCREMENT,
                                                        `professor_ID` INT NOT NULL,
                                                        `course_name` VARCHAR(45) NOT NULL,
                                                        `course_description` VARCHAR(250) NOT NULL,
                                                        `sysAdmin` INT NULL,
                                                        PRIMARY KEY (`course_ID`),
                                                        INDEX `professor_ID_idx` (`professor_ID` ASC) VISIBLE,
                                                        INDEX `sysAdmin_idx` (`sysAdmin` ASC) VISIBLE,
                                                        CONSTRAINT `professor_ID`
                                                            FOREIGN KEY (`professor_ID`)
                                                                REFERENCES `gradingsystem`.`professor` (`professor_ID`),
                                                        CONSTRAINT `courseSysAdmin`
                                                            FOREIGN KEY (`sysAdmin`)
                                                                REFERENCES `gradingsystem`.`sysadmin` (`admin_ID`)
                                                                ON DELETE NO ACTION
                                                                ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`student` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`student` (
                                                         `student_ID` INT NOT NULL AUTO_INCREMENT,
                                                         `first_name` VARCHAR(45) NOT NULL,
                                                         `last_name` VARCHAR(45) NOT NULL,
                                                         `email` VARCHAR(45) NOT NULL,
                                                         `gpa` DOUBLE NULL,
                                                         `sysAdmin` INT NULL,
                                                         PRIMARY KEY (`student_ID`),
                                                         INDEX `sysAdmin_idx` (`sysAdmin` ASC) VISIBLE,
                                                         CONSTRAINT `studentSysAdmin`
                                                             FOREIGN KEY (`sysAdmin`)
                                                                 REFERENCES `gradingsystem`.`sysadmin` (`admin_ID`)
                                                                 ON DELETE NO ACTION
                                                                 ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`course_enrollment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`course_enrollment` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`course_enrollment` (
                                                                   `student_ID` INT NOT NULL,
                                                                   `course_ID` INT NOT NULL,
                                                                   `course_grade` DECIMAL(5,2) NOT NULL,
                                                                   PRIMARY KEY (`student_ID`, `course_ID`),
                                                                   INDEX `course_ID_idx` (`course_ID` ASC) VISIBLE,
                                                                   CONSTRAINT `course_ID`
                                                                       FOREIGN KEY (`course_ID`)
                                                                           REFERENCES `gradingsystem`.`course` (`course_ID`),
                                                                   CONSTRAINT `ce_student_ID`
                                                                       FOREIGN KEY (`student_ID`)
                                                                           REFERENCES `gradingsystem`.`student` (`student_ID`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`Exam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`Exam` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`Exam` (
                                                      `exam_number` INT NOT NULL AUTO_INCREMENT,
                                                      `name` VARCHAR(45) NULL,
                                                      `feedback` VARCHAR(250) NULL,
                                                      PRIMARY KEY (`exam_number`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradingsystem`.`student_exam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`student_exam` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`student_exam` (
                                                              `student_ID` INT NOT NULL,
                                                              `exam_number` INT NOT NULL,
                                                              `exam_grade` DOUBLE NOT NULL,
                                                              PRIMARY KEY (`student_ID`, `exam_number`),
                                                              INDEX `exam_number_idx` (`exam_number` ASC) VISIBLE,
                                                              CONSTRAINT `exam_student_ID`
                                                                  FOREIGN KEY (`student_ID`)
                                                                      REFERENCES `gradingsystem`.`student` (`student_ID`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION,
                                                              CONSTRAINT `exam_number`
                                                                  FOREIGN KEY (`exam_number`)
                                                                      REFERENCES `gradingsystem`.`Exam` (`exam_number`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradingsystem`.`sysAdminLogins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`sysAdminLogins` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`sysAdminLogins` (
                                                                `ID` INT NOT NULL,
                                                                `email` VARCHAR(45) NULL,
                                                                `password` VARCHAR(45) NOT NULL,
                                                                PRIMARY KEY (`ID`),
                                                                CONSTRAINT `sysAdminID`
                                                                    FOREIGN KEY (`ID`)
                                                                        REFERENCES `gradingsystem`.`sysadmin` (`admin_ID`)
                                                                        ON DELETE NO ACTION
                                                                        ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradingsystem`.`studentLogins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`studentLogins` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`studentLogins` (
                                                               `ID` INT NOT NULL,
                                                               `email` VARCHAR(45) NULL,
                                                               `password` VARCHAR(45) NOT NULL,
                                                               PRIMARY KEY (`ID`),
                                                               CONSTRAINT `studentIDLogin`
                                                                   FOREIGN KEY (`ID`)
                                                                       REFERENCES `gradingsystem`.`student` (`student_ID`)
                                                                       ON DELETE NO ACTION
                                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradingsystem`.`professorLogins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gradingsystem`.`professorLogins` ;

CREATE TABLE IF NOT EXISTS `gradingsystem`.`professorLogins` (
                                                                 `ID` INT NOT NULL,
                                                                 `email` VARCHAR(45) NULL,
                                                                 `password` VARCHAR(45) NOT NULL,
                                                                 PRIMARY KEY (`ID`))
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
