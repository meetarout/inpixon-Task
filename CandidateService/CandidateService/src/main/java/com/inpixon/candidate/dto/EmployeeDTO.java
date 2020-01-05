package com.inpixon.candidate.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7764968212863749956L;
	
	private Long id;
	
    private String companyName;

	private String jobTitle;
	
	private String jobLocation;
	
	private int jobSalary;
	
	
	
	
	

}
