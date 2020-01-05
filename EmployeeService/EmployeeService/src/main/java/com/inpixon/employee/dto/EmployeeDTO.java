package com.inpixon.employee.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class representing a the Employee details ")
public class EmployeeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7764968212863749956L;
	
	@ApiModelProperty(notes = "Uniqe identifier of the Employee")
	private Long id;
	
	@ApiModelProperty(notes = "Company Name For Employee")
    private String companyName;

	@ApiModelProperty(notes = "JobTitle For Employee")
	private String jobTitle;
	
	@ApiModelProperty(notes = "Job Location For Employee")
	private String jobLocation;
	
	@ApiModelProperty(notes = "Job Salary For Employee")
	private int jobSalary;
	
	
	
	
	

}
