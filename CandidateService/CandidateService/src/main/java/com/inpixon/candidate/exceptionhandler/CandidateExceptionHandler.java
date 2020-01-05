package com.inpixon.candidate.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inpixon.candidate.dto.ResponseDTO;
import com.inpixon.candidate.exception.CandidateNotFoundByIdException;
import com.inpixon.candidate.exception.CandidateNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CandidateExceptionHandler {
	
	@Autowired ResponseDTO responseDTO;
	
	
	@ExceptionHandler(CandidateNotFoundException.class)
	@ResponseBody
	protected ResponseDTO candidateNotFoundException(CandidateNotFoundException ex) {
		
		responseDTO.setResponseCode("404");
		responseDTO.setResposeStatus(ex.getMessage());
		return responseDTO;
		
	}
	
	
	@ExceptionHandler(CandidateNotFoundByIdException.class)
	@ResponseBody
	protected ResponseDTO candidateNotFoundExceptionById(CandidateNotFoundByIdException exId) {
		
		responseDTO.setResponseCode("404");
		responseDTO.setResposeStatus(exId.getMsg());
		return responseDTO;
		
	}

}
