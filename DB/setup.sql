CREATE DATABASE PayrollProgDB;
USE PayrollProgDB;
---------------------------------------
CREATE TABLE employee (
  IDNumber int NOT NULL PRIMARY KEY
  firstName varchar(45) NOT NULL,
  lastName varchar(45) NOT NULL,
  SSNumber int NOT NULL,
  Address varchar(45) NOT NULL,
  dateOfBirth varchar(45) NOT NULL,
  homePhoneNumber varchar(45) NOT NULL,
  MobilePhoneNumber varchar(45) NOT NULL,
  emailAddress varchar(255) NOT NULL,
  employedSince varchar(45) NOT NULL,
  hoursWorkedLastPayPeriod int NOT NULL,
  fullTime varchar(45) NOT NULL,
  Field1 varchar(45) NOT NULL,
) 
-------------------------------------------------------------------------
CREATE TABLE benefit (
  BenefitID int NOT NULL PRIMARY KEY 
  Name varchar(45) NOT NULL,
  AmountResponsibleFor varchar(45) NOT NULL,
  amountGiven int NOT NULL,
  includesFamily varchar(45) NOT NULL,
  
) 
-----------------------------------------------------------------------------------
CREATE TABLE hr (
  IDNumber int NOT NULL PRIMARY KEY 
  Password varchar(45) NOT NULL 
  -- numEmployee int NOT NULL,
) 
------------------------------------------------------------
CREATE TABLE silverpackage (
  BenefitsID int NOT NULL PRIMARY KEY 
) 
--------------------------------------------
CREATE TABLE goldpackage (
  BenefitsID int NOT NULL PRIMARY KEY
) 
-----------------------------------------------------
CREATE TABLE bronzepackage (
  BenefitsID int NOT NULL PRIMARY KEY
) 
INSERT INTO hr (IDNumber, Password) VALUES (1337420, 'imtheman')