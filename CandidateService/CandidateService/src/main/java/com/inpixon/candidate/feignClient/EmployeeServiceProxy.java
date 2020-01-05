package com.inpixon.candidate.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.inpixon.candidate.dto.ResponseDTO;

@FeignClient(name="employee-service",url="localhost:8081")
public interface EmployeeServiceProxy {

	@GetMapping(path="/employee-details/employees")
	public ResponseDTO getAllEmployees();
	
	
}
