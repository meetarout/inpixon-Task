package com.inpixon.candidate.service;

import com.inpixon.candidate.dto.CandidateDTO;
import com.inpixon.candidate.dto.CandidateEmployeeResponseDTO;
import com.inpixon.candidate.exception.CandidateNotFoundByIdException;
import com.inpixon.candidate.exception.CandidateNotSaveException;

public interface CandidateServiceI {
	
	
    public CandidateEmployeeResponseDTO getAllCandidates() throws Exception;
	
	public CandidateDTO getCandidateById(Long id) throws  CandidateNotFoundByIdException;
	
	public void deleteCandidateById(Long id) throws CandidateNotFoundByIdException;
	
	public CandidateDTO save(CandidateDTO candidateDTO) throws CandidateNotSaveException;
	
	public CandidateDTO update(CandidateDTO candidateDTO) throws CandidateNotFoundByIdException, CandidateNotSaveException ;
		

}
