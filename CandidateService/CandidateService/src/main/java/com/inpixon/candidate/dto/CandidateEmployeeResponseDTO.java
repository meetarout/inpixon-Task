package com.inpixon.candidate.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CandidateEmployeeResponseDTO {
	
	private List<EmployeeDTO>  listEmployeeDto;
	private List<CandidateDTO>  listCandidateDto;

}
