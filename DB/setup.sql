CREATE DATABASE PayrollProgDB;
USE PayrollProgDB;
---------------------------------------
CREATE TABLE employee (
  IDNumber int NOT NULL PRIMARY KEY,
  firstName varchar(45) NOT NULL,
  lastName varchar(45) NOT NULL,
  SSNumber varchar(11) NOT NULL,
  Address varchar(45) NOT NULL,
  dateOfBirth varchar(45) NOT NULL,
  homePhoneNumber varchar(45),
  MobilePhoneNumber varchar(45) NOT NULL,
  emailAddress varchar(255) NOT NULL,
  employedSince varchar(45) NOT NULL,
  hoursWorkedLastPayPeriod int,
  fullTime boolean NOT NULL,
  grossIncome int,
  netIncome int,
  BenefitPackage varchar(6),
  Password varchar(20)
);
-------------------------------------------------------------------------
CREATE TABLE benefit (
  BenefitID int NOT NULL auto_increment PRIMARY KEY,
  Name varchar(45) NOT NULL,
  amountGiven int NOT NULL,
  includesFamily boolean NOT NULL
); 
-----------------------------------------------------------------------------------
CREATE TABLE hr (
  IDNumber int NOT NULL PRIMARY KEY, 
  Password varchar(45) NOT NULL 
);
------------------------------------------------------------
CREATE TABLE silverpackage (
  Name varchar(45) NOT NULL PRIMARY KEY,
  cost int NOT NULL,
  includesFamily boolean NOT NULL
); 
--------------------------------------------
CREATE TABLE goldpackage (
  Name varchar(45) NOT NULL PRIMARY KEY,
  cost int NOT NULL,
  includesFamily boolean NOT NULL
); 
-----------------------------------------------------
CREATE TABLE bronzepackage (
  Name varchar(45) NOT NULL PRIMARY KEY,
  cost int NOT NULL,
  includesFamily boolean NOT NULL
); 
-- hard coded benefits
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Health Insurance',12000,true);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Life Insurance', 10000,false);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Legal Insurance', 5000,false);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Disability Protection',3000,true);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Daycare',8000,true);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Paternal Leave', 8000,true);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Education', 6000,true);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Transportation',1000,false);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Housing',12000,true);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Paid Vacation',2000,false);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Dental Care',500,true);
INSERT INTO benefit(Name,amountGiven,includesFamily) VALUES ('Vision Care',200,true);
-- hard coded bronze package
INSERT INTO bronzepackage(Name,cost,includesFamily) VALUES ('Health Insurance',12000,true);
INSERT INTO bronzepackage(Name,cost,includesFamily) VALUES ('Disability Protection',3000,true);
INSERT INTO bronzepackage(Name,cost,includesFamily) VALUES ('Paid Vacation',2000,false);
INSERT INTO bronzepackage(Name,cost,includesFamily) VALUES ('Dental Care',500,true);
INSERT INTO bronzepackage(Name,cost,includesFamily) VALUES ('Vision Care',200,true);
-- hard coded silver package
INSERT INTO silverpackage(Name,cost,includesFamily) VALUES ('Health Insurance',12000,true);
INSERT INTO silverpackage(Name,cost,includesFamily) VALUES ('Disability Protection',3000,true);
INSERT INTO silverpackage(Name,cost,includesFamily) VALUES ('Paid Vacation',2000,false);
INSERT INTO silverpackage(Name,cost,includesFamily) VALUES ('Dental Care',500,true);
INSERT INTO silverpackage(Name,cost,includesFamily) VALUES ('Vision Care',200,true);
INSERT INTO silverpackage(Name,cost,includesFamily) VALUES ('Transportation',1000,false);
INSERT INTO silverpackage(Name,cost,includesFamily) VALUES ('Legal Insurance',5000,false);
INSERT INTO silverpackage(Name,cost,includesFamily) VALUES ('Housing',12000,true);
-- hard coded gold package
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Health Insurance',12000,true);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Life Insurance', 10000,false);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Legal Insurance', 5000,false);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Disability Protection',3000,true);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Daycare',8000,true);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Paternal Leave', 8000,true);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Education', 6000,true);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Transportation',1000,false);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Housing',12000,true);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Paid Vacation',2000,false);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Dental Care',500,true);
INSERT INTO goldpackage(Name,cost,includesFamily) VALUES ('Vision Care',200,true);

INSERT INTO hr (IDNumber, Password) VALUES (1337420, 'imtheman');