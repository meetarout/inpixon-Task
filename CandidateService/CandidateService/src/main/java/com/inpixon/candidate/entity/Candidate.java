package com.inpixon.candidate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="candidate_table")
public class Candidate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5792343864135935920L;
	
	@Id
	private Long id;
	
	@Column(name="Candidate_Name")
	private String candidateName;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Salary")
	private String salary;
	
	
	
	
	
	
	
	

}
