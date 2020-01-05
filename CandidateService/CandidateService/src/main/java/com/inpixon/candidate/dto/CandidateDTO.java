package com.inpixon.candidate.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class representing a the candidate details ")
public class CandidateDTO  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6492365140750735824L;
	
	@ApiModelProperty(notes = "Uniqe identifier of the candidate")
	private Long id;

	@ApiModelProperty(notes = "candidateName  For candidate")
	private String candidateName;
	
	@ApiModelProperty(notes = "location  For candidate")
	private String location;
	
	@ApiModelProperty(notes = "salary  For candidate")
	private String salary;
	
	

}
