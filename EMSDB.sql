show databases;
create database Employee_Management_System;
use Employee_Management_System;
 
--  =============== ROLE TABLE =================
 
 CREATE TABLE `Employee_Management_System`.`role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(75) NOT NULL,
  `description` TINYTEXT NULL,
  PRIMARY KEY (`id`)); 	 	
 
--  =============== USER TABLE =================

 CREATE TABLE `Employee_Management_System`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `roleId` BIGINT NOT NULL,
  `username` BIGINT(20) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `lastLogin` DATETIME  DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`roleId`)
    REFERENCES `Employee_Management_System`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION); 

 ALTER TABLE USER AUTO_INCREMENT=1;
 
 --  =============== DEPARTMENT  TABLE =================

 CREATE TABLE DEPARTMENT
(ID int(3) NOT NULL PRIMARY KEY,
DNAME VARCHAR(14),
LOCATION VARCHAR(13),
STATUS CHAR(1) );

 --  =============== WORK_LOCATION  TABLE =================

CREATE TABLE WORK_LOCATION_ADDRESS(
LOCATION_CODE VARCHAR(20) NOT NULL PRIMARY KEY,
BUILDING_ID VARCHAR(20) NOT NULL,
LOCATION VARCHAR(30) NULL,
ZIP INT(6) NOT NULL
);

--  =============== EMPLOYEE TABLE =================

CREATE TABLE IF NOT EXISTS employee ( 
EMPLOYEE_ID bigint(20) NOT NULL PRIMARY KEY, 
FIRST_NAME varchar(20) NOT NULL, 
MIDDLE_NAME VARCHAR(20) DEFAULT NULL,
LAST_NAME varchar(25) DEFAULT NULL, 
GENDER VARCHAR(6)  NOT NULL,
EMAIL varchar(45) NOT NULL, 
DOB DATE NOT NULL,
DESIGNATION varchar(20) not null,
ROLE_ID bigint not null,
PHONE_NUMBER varchar(20) NOT NULL,
DEPARTMENT_ID int(5) DEFAULT NULL, 
WORK_LOCATION varchar(20) not null,
HIRE_DATE DATE NOT NULL, 
EMP_STATUS char(1) not null,
ADDED_ON timestamp,
MODIFIED_ON timestamp,
FOREIGN KEY(DEPARTMENT_ID) REFERENCES  department(ID), 
FOREIGN KEY(ROLE_ID) REFERENCES  role(ID),
foreign key(work_location) references WORK_LOCATION_ADDRESS(LOCATION_CODE)
);

--  =============== EMPLOYEE ADDRESS TABLE =================

Create table if not exists employee_address(
ID int not null AUTO_INCREMENT PRIMARY KEY,
employee_id bigint(20) NOT NULL,
house_address_line1 varchar(20)  NOT NULL,
house_address_line2 varchar(20) DEFAULT NULL,
street varchar(30)  NOT NULL,
city varchar(30)  NOT NULL,
state varchar(30)  NOT NULL,
zip int(6)  NOT NULL,
FOREIGN KEY(employee_id) 
REFERENCES  employee(employee_id)
);




 --  =============== SALARY  TABLE =================

Create table if not exists salary(
ID int not null AUTO_INCREMENT PRIMARY KEY,
employee_id bigint(20) NOT NULL,
basic_salary DECIMAL(10,2) NOT NULL,
hra_percent int(2) NOT NULL,
HRA DECIMAL(10,2) NOT NULL,
da_percent int(2) NOT NULL,
DA DECIMAL(10,2) NOT NULL,
gross_salary DECIMAL(10,2) NOT NULL,
it_percent int(2) NOT NULL,
income_tax DECIMAL(10,2) NOT NULL,
net_salary DECIMAL(10,2) NOT NULL,
ADDED_ON timestamp,
MODIFIED_ON timestamp,
FOREIGN KEY(employee_id) 
REFERENCES  employee(employee_id)
);
ALTER TABLE salary ADD CONSTRAINT uniqueconstraint UNIQUE(`employee_id`);
 ALTER TABLE salary AUTO_INCREMENT=1001;
 
insert into role values(1,'admin','Has Acces to update employee details');
insert into role values(2,'user','Has acces to only view the details');

insert into user values(1,1,9632659833,'Admin@123',sysdate());
insert into user values(2,2,9902308245,'Admin@123',sysdate());


insert into WORK_LOCATION_ADDRESS values('mng01','build_1','Mangalore',576101);
insert into WORK_LOCATION_ADDRESS values('bng02','build_2','Bangalore',575001);
insert into WORK_LOCATION_ADDRESS values('mng03','build_3','Mangalore',576001);


