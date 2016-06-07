# HibernateInheritanceTablePerSubclass
Using  Annotation Mapping

In case of <b>Table Per Subclass</b>, subclass mapped tables are related to parent class mapped table by <b>primary key</b> and <b>foreign key</b> relationship.

In <b>One Table per Subclass</b> scheme, each class persist the data in its own separate table. 
Thus we have 3 tables; Employees, regular_employee and contract_employee to persist the class data. 
Note that a foreign key relationship exists between the subclass tables and super class table. 
Thus the common data is stored in employees table and subclass specific fields are stored in regular_employee and contract_employee tables.

One Table Per Subclass example
--------------------------------------

						              Employee
							                ^
							                |
					----------------------------------------------
					|					                         |
		RegularEmployee		                      ContractEmployee







RDBMS (MySQL) Table Script:
------------------------------
#employees
CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

#regular_employee
CREATE TABLE `regular_employee` (
  `regempid` bigint(20) NOT NULL AUTO_INCREMENT,
	`salary` float,
	`bonus` float,
  PRIMARY KEY (`regempid`),
  CONSTRAINT `fk_regempid` FOREIGN KEY (`regempid`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

#contract_employee
CREATE TABLE `contract_employee` (
  `contempid` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_per_hour` float,
  `contract_duration` varchar(255),
   PRIMARY KEY (`contempid`),
   CONSTRAINT `fk_contempid` FOREIGN KEY (`contempid`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
