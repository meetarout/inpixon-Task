package com.inpixon.candidate.dto;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ResponseDTO {
	
	private String resposeStatus;
	
	private String responseCode;
	
	private Object object;

}
