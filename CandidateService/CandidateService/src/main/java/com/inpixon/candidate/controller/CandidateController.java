package com.inpixon.candidate.controller;

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

import com.inpixon.candidate.dto.CandidateDTO;
import com.inpixon.candidate.dto.CandidateEmployeeResponseDTO;
import com.inpixon.candidate.dto.ResponseDTO;
import com.inpixon.candidate.exception.CandidateNotFoundByIdException;
import com.inpixon.candidate.exception.CandidateNotSaveException;
import com.inpixon.candidate.service.CandidateServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/candidate-details",produces=MediaType.APPLICATION_JSON_VALUE)
@Api(value = "This Endpoints are to findout candidate Service Details")
public class CandidateController {
	
	@Autowired
	private CandidateServiceI candidateService;
	
	@Lookup
	public ResponseDTO getResponseDto() {
		return null;
	}
	
	@GetMapping(path="/candidates",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Fetch All The candidates ", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "candidate Get Successfully"),
			@ApiResponse(code = 202, message = "No candidates Found") })
	public ResponseDTO getAllCandidates() throws Exception {
		CandidateEmployeeResponseDTO allCandidatesAndEmployee = candidateService.getAllCandidates();
		ResponseDTO resDto = getResponseDto();
		if(allCandidatesAndEmployee==null) {
			resDto.setResposeStatus("no candidates available");
			resDto.setResponseCode("202");
		}
		else {
			resDto.setResposeStatus("Candidate Get Successfully");
		}
		resDto.setObject(allCandidatesAndEmployee);
		resDto.setResponseCode("200");
		return resDto;
		
	}
	
	@GetMapping(path="/candidateById/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Fetch the candidate by id ", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "id found successfully")})
	public  ResponseDTO getCandidateById(@PathVariable Long id) throws CandidateNotFoundByIdException{
		 CandidateDTO candidateById = candidateService.getCandidateById(id);
		 ResponseDTO resDto = getResponseDto();
		 resDto.setObject(candidateById);
		 resDto.setResponseCode("200");
		 resDto.setResposeStatus("id found successfully");
		 return resDto;
		 
	}
	
	@DeleteMapping(path="/deletecandidates/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="delete  candidate by id ", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "id deleted successfully")})
	public ResponseDTO deleteCandidateById(@PathVariable Long id) throws CandidateNotFoundByIdException {
		candidateService.deleteCandidateById(id);
		ResponseDTO resDto = getResponseDto();
		resDto.setResponseCode("200");
		resDto.setResposeStatus("id deleted successfully");
		return resDto;
	}
	
	
	@PostMapping("/savecandidates")
	@ApiOperation(value="save candidate ", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = " candidate data saved successfully")})
	public ResponseDTO save(@RequestBody CandidateDTO candidateDTO) throws CandidateNotSaveException {
		CandidateDTO save = candidateService.save(candidateDTO);
		ResponseDTO resDto = getResponseDto();
		resDto.setObject(save);
		resDto.setResponseCode("201");
		resDto.setResposeStatus("candidate data saved successfully");
		return resDto;
	}
	
	@PutMapping("/updatecandidates/{id}")
	@ApiOperation(value="update candidate ", response = ResponseDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "candidate data updated successfully")})
	public ResponseDTO update(@RequestBody CandidateDTO candidateDTO,@PathVariable Long id) throws CandidateNotFoundByIdException, CandidateNotSaveException {
		candidateDTO.setId(id);
		CandidateDTO update = candidateService.update(candidateDTO);
		ResponseDTO resDto = getResponseDto();
        resDto.setObject(update);
		resDto.setResponseCode("200");
		resDto.setResposeStatus("candidate data updated successfully");
		return resDto;
		
	}
	
	

}
