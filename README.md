Setup For Mysql::

1) CREATE SCHEMA 'candidate_schema'
2) CREATE TABLE `candidate_table` (
  `id` bigint(20) NOT NULL,
  `candidate_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

Setup For Oracle ::
1) Login as "sys as sysdba"
"sysdba"
2) create user employee IDENTIFIED BY employee;
3) grant create session to employee;
4) commit;
5) GRANT RESOURCE to employee;
6) commit;
7) grant unlimited tablespace to employee;
8) commit;


Setup For Project::

1) Start the Eureka Naming Server
url :: http://localhost:8761/eureka

2) To Setup the employee service please add the ojdbc6 jar in classpath

Get All Employee::
http::localhost:8081/employee-details/employees

Get Employees By Id::
http::localhost:8081/employee-details/employeeById/1

Delete Employee By Id::
http::localhost:8081/employee-details/deleteEmployees/1

Save Employees::
http::localhost:8081/employee-details/saveEmployees
--Input
{
"companyName" : "inpixon38",
"jobTitle"  : "software engineer",
"jobLocation": "hyd",
 "jobSalary": 1000
}

Update Employee::
http::localhost:8081/employee-details/updateEmployee/1

{
"companyName" : "inpixon38",
"jobTitle"  : "software engineer",
"jobLocation": "hyd",
 "jobSalary": 1000
}

Hystrix URL ::  http://localhost:8081/hystrix/
Swagger URL ::  http://localhost:8081/swagger-ui.html

3) Setup Candidate Service ::

Get All Candiate::
localhost:8080/candidate-details/candidates

Get Employees By Id::
localhost:8080/candidate-details/candidateById/1

Delete Employee By Id::
http::localhost:8081/candidate-details/deletecandidates/1

Save Employees::
http::localhost:8081/candidate-details/savecandidates
--Input
{
 "candidateName": "meeta10" ,
 "location":"hyderabad" ,
 "salary":"750"
 }

Update Employee::
http::localhost:8081/candidate-details/updateEmployee/1

{
 "candidateName": "meeta10" ,
 "location":"hyderabad" ,
 "salary":"750"
}


Swagger URL ::  http://localhost:8080/swagger-ui.html













