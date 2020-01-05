package com.inpixon.employee.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope(value="prototype")
public class ResponseDTO {
	
	private String resposeStatus;
	private String responseCode;
	private Object object;
	
	

}
