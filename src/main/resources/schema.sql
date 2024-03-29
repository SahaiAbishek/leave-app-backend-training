CREATE TABLE `EMPLOYEE` 
(  
	`EMP_ID`  integer not null auto_increment,
	`EMP_NAME` char(20) NOT NULL,  
	`EMP_PHONE` bigint(20) DEFAULT NULL,  
	`EMP_DEPT` varchar(20),  
	`EMP_MAIL` char(40) DEFAULT NULL,  
	`EMP_DOJ` date NOT NULL,  
	`LEAVE_BALANCE` int(11) NOT NULL,  
	`EMP_MNG_ID` int(11) DEFAULT NULL, 
	PRIMARY KEY (`EMP_ID`),  
	UNIQUE KEY `EMP_MAIL` (`EMP_MAIL`)
) ;


CREATE TABLE `LEAVE_HISTORY` 
(  
	`LEAVE_ID` integer not null AUTO_INCREMENT,
	`NUMBER_OF_DAYS` int(11) DEFAULT NULL,  
	`START_DATE` date NOT NULL,  
	`END_DATE` date NOT NULL,  
	`LEAVE_STATUS` enum('APPROVED','PENDING','DENIED') DEFAULT NULL,  
	`APPLIED_ON` date NOT NULL,  
	`MANAGER_COMMENTS` char(50) DEFAULT NULL,  
	`EMP_ID` integer ,
	`REASONS` varchar(50) NOT NULL,  
	`LEAVE_TYPE` enum('EL') DEFAULT NULL,  
	PRIMARY KEY (`LEAVE_ID`), 
	FOREIGN KEY (`EMP_ID`) REFERENCES `employee` (`EMP_ID`));