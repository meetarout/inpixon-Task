package com.inpixon.employee.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inpixon.employee.dto.EmployeeDTO;
import com.inpixon.employee.dto.ResponseDTO;
import com.inpixon.employee.exception.EmployeeNotSaveException;
import com.inpixon.employee.exception.EmployeeNotfoundByIdException;
import com.inpixon.employee.service.EmployeeServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/employee-details",produces=MediaType.APPLICATION_JSON_VALUE)
@Api(value = "This Endpoints are to findout Employee Service Details")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceI employeeServiceI;
	
	@Lookup
	public ResponseDTO getResponseDto() {
		return null;
	}
	
	@GetMapping(path="/employees",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Fetch All The Employess ", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "employee Get Successfully"),
			@ApiResponse(code = 202, message = "No Employee Found") })
	public ResponseDTO getAllEmployees() throws Exception {
		List<EmployeeDTO> allEmployees = employeeServiceI.getAllEmployees();
		ResponseDTO resDto = getResponseDto();
		if(CollectionUtils.isEmpty(allEmployees)) {
			resDto.setResposeStatus("no employees available");
			resDto.setResponseCode("202");
		}
		else {
			resDto.setResposeStatus("employee Get Successfully");
			resDto.setResponseCode("200");
		}
		resDto.setObject(allEmployees);
		return resDto;
		
	}
	
	@GetMapping(path="/employeeById/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Fetch  Employee by id", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "id found successfully")})
	public  ResponseDTO getEmployeeById(@PathVariable Long id) throws EmployeeNotfoundByIdException{
		 EmployeeDTO employeeById = employeeServiceI.getEmployeeById(id);
		 ResponseDTO resDto = getResponseDto();
		 resDto.setObject(employeeById);
		 resDto.setResponseCode("200");
		 resDto.setResposeStatus("id found successfully");
		 return resDto;
		 
	}
	
	@DeleteMapping(path="/deleteEmployees/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="delete employee by id ", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "id deleted successfully")})
	public ResponseDTO deleteCandidateById(@PathVariable Long id) throws EmployeeNotfoundByIdException{
		employeeServiceI.deleteEmployeeById(id);
		ResponseDTO resDto = getResponseDto();
		resDto.setResponseCode("200");
		resDto.setResposeStatus("id deleted successfully");
		return resDto;
	}
	
	
	@PostMapping("/saveEmployees")
	@ApiOperation(value="save All  Employess ", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "employee data saved successfully")})
	public ResponseDTO save(@RequestBody EmployeeDTO employeeDTO) throws EmployeeNotSaveException {
		EmployeeDTO save = employeeServiceI.saveEmployee(employeeDTO);
		ResponseDTO resDto = getResponseDto();
		resDto.setObject(save);
		resDto.setResponseCode("201");
		resDto.setResposeStatus("employee data saved successfully");
		return resDto;
	}
	
	@PutMapping("/updateEmployee/{id}")
	@ApiOperation(value="update All The Employess ", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "employee data updated successfully")})
	public ResponseDTO update(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long id) throws EmployeeNotfoundByIdException, EmployeeNotSaveException{
		employeeDTO.setId(id);
		EmployeeDTO update = employeeServiceI.updateEmployee(employeeDTO);
		ResponseDTO resDto = getResponseDto();
        resDto.setObject(update);
		resDto.setResponseCode("200");
		resDto.setResposeStatus("employee data updated successfully");
		return resDto;
		
	}
	
	
	
	
	
	
	
	

}
