-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gradingsystem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gradingsystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gradingsystem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `gradingsystem` ;

-- -----------------------------------------------------
-- Table `gradingsystem`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradingsystem`.`professor` (
                                                           `professor_ID` INT NOT NULL AUTO_INCREMENT,
                                                           `first_name` VARCHAR(45) NOT NULL,
                                                           `last_name` VARCHAR(45) NOT NULL,
                                                           `email` VARCHAR(45) NOT NULL,
                                                           `phone` VARCHAR(10) NULL,
                                                           PRIMARY KEY (`professor_ID`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradingsystem`.`course` (
                                                        `course_ID` INT NOT NULL AUTO_INCREMENT,
                                                        `professor_ID` INT NOT NULL,
                                                        `name` VARCHAR(45) NOT NULL,
                                                        `description` VARCHAR(150) NULL DEFAULT NULL,
                                                        PRIMARY KEY (`course_ID`),
                                                        INDEX `professor_ID_idx` (`professor_ID` ASC) VISIBLE,
                                                        CONSTRAINT `professor_ID`
                                                            FOREIGN KEY (`professor_ID`)
                                                                REFERENCES `gradingsystem`.`professor` (`professor_ID`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradingsystem`.`student` (
                                                         `student_ID` INT NOT NULL AUTO_INCREMENT,
                                                         `first_name` VARCHAR(45) NOT NULL,
                                                         `last_name` VARCHAR(45) NOT NULL,
                                                         `email` VARCHAR(45) NOT NULL,
                                                         `gpa` DECIMAL(10,0) NOT NULL,
                                                         PRIMARY KEY (`student_ID`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 6
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`course_enrollment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradingsystem`.`course_enrollment` (
                                                                   `student_ID` INT NOT NULL,
                                                                   `course_ID` INT NOT NULL,
                                                                   `course_grade` DECIMAL(10,0) NOT NULL,
                                                                   PRIMARY KEY (`student_ID`, `course_ID`),
                                                                   INDEX `course_ID_idx` (`course_ID` ASC) VISIBLE,
                                                                   CONSTRAINT `ce_student_ID`
                                                                       FOREIGN KEY (`student_ID`)
                                                                           REFERENCES `gradingsystem`.`student` (`student_ID`),
                                                                   CONSTRAINT `course_ID`
                                                                       FOREIGN KEY (`course_ID`)
                                                                           REFERENCES `gradingsystem`.`course` (`course_ID`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradingsystem`.`exam` (
                                                      `exam_number` INT NOT NULL AUTO_INCREMENT,
                                                      `name` VARCHAR(45) NULL DEFAULT NULL,
                                                      `description` VARCHAR(45) NULL DEFAULT NULL,
                                                      PRIMARY KEY (`exam_number`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`student_exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradingsystem`.`student_exam` (
                                                              `student_ID` INT NOT NULL,
                                                              `exam_number` INT NOT NULL,
                                                              `exam_grade` INT NOT NULL,
                                                              PRIMARY KEY (`student_ID`, `exam_number`),
                                                              INDEX `exam_number_idx` (`exam_number` ASC) VISIBLE,
                                                              CONSTRAINT `exam_number`
                                                                  FOREIGN KEY (`exam_number`)
                                                                      REFERENCES `gradingsystem`.`exam` (`exam_number`),
                                                              CONSTRAINT `exam_student_ID`
                                                                  FOREIGN KEY (`student_ID`)
                                                                      REFERENCES `gradingsystem`.`student` (`student_ID`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradingsystem`.`sysadmin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradingsystem`.`sysadmin` (
                                                          `admin_ID` INT NOT NULL AUTO_INCREMENT,
                                                          `first_name` VARCHAR(45) NOT NULL,
                                                          `last_name` VARCHAR(45) NOT NULL,
                                                          `email` VARCHAR(45) NOT NULL,
                                                          PRIMARY KEY (`admin_ID`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
