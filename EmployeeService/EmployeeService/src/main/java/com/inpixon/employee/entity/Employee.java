package com.inpixon.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	private Long id;
	
	@Column(name="Company_Name")
	private String companyName;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="job_location")
	private String jobLocation;
	
	@Column(name="job_salary")
	private int jobSalary;
	
	
	
	
	
	

}
