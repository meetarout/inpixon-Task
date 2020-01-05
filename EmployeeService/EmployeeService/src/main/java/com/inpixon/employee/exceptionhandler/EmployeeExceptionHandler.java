package com.inpixon.employee.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inpixon.employee.dto.ResponseDTO;
import com.inpixon.employee.exception.EmployeeNotfoundByIdException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EmployeeExceptionHandler {
	
	@Autowired
	ResponseDTO responseDTO;
	
	
	/*@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseBody
	public ResponseDTO employeeNotFoundException(EmployeeNotFoundException ex) {
		responseDTO.setResponseCode("404");
		responseDTO.setResposeStatus(ex.getMessage());
		return responseDTO;
		
	}*/
	@ExceptionHandler(EmployeeNotfoundByIdException.class)
	@ResponseBody
	public ResponseDTO employeeNotfoundByIdException(EmployeeNotfoundByIdException ex) {
		responseDTO.setResponseCode("404");
		responseDTO.setResposeStatus(ex.getMessage());
		return responseDTO;
		
	}
	@ExceptionHandler(com.inpixon.employee.exception.EmployeeNotSaveException.class)
	@ResponseBody
	public ResponseDTO employeeNotSaveException(com.inpixon.employee.exception.EmployeeNotSaveException ex) {
		responseDTO.setResponseCode("404");
		responseDTO.setResposeStatus(ex.getMessage());
		return responseDTO;
		
	}
	
	

}
