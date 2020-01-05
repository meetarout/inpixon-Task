package com.inpixon.candidate.service;

import static com.inpixon.candidate.constant.CommonConstant.CANDIDATE_FAIL_TO_SAVE;
import static com.inpixon.candidate.constant.CommonConstant.NO_CANDIDATES_FOUND;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inpixon.candidate.dto.CandidateDTO;
import com.inpixon.candidate.dto.CandidateEmployeeResponseDTO;
import com.inpixon.candidate.dto.EmployeeDTO;
import com.inpixon.candidate.dto.ResponseDTO;
import com.inpixon.candidate.entity.Candidate;
import com.inpixon.candidate.exception.CandidateNotFoundByIdException;
import com.inpixon.candidate.exception.CandidateNotFoundException;
import com.inpixon.candidate.exception.CandidateNotSaveException;
import com.inpixon.candidate.feignClient.EmployeeServiceProxy;
import com.inpixon.candidate.repository.CandidateRepository;
import com.inpixon.candidate.util.ModelMapperImpl;

@Service
public class CandidateService implements CandidateServiceI {

	

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private ModelMapperImpl modelMapperImpl;
	
	@Autowired
	EmployeeServiceProxy employeeServiceProxy;
	
	@Autowired
	CandidateEmployeeResponseDTO ceDto;

	@Override
	public CandidateEmployeeResponseDTO getAllCandidates() throws Exception {
		try {
			List<Candidate> findAll = candidateRepository.findAll();
			if (CollectionUtils.isEmpty(findAll)) {
				return null;
			}
			List<CandidateDTO> cnddto = findAll.stream()
					.map(candidate -> (CandidateDTO) modelMapperImpl.convert(candidate, CandidateDTO.class))
					.collect(Collectors.toList());
			
			/*ResponseEntity<ResponseDTO> forEntity = new RestTemplate().getForEntity("http://localhost:8082/employee-details/employees", ResponseDTO.class);
			ResponseDTO body = forEntity.getBody();
			List<EmployeeDTO> empdto =(List<EmployeeDTO>)body.getObject();*/
			
			ResponseDTO allEmployees = employeeServiceProxy.getAllEmployees();
			List<EmployeeDTO> empdto =(List<EmployeeDTO>)allEmployees.getObject();
			ceDto.setListCandidateDto(cnddto);
			ceDto.setListEmployeeDto(empdto);
			return ceDto;
		} catch (Exception e) {
			throw new CandidateNotFoundException(NO_CANDIDATES_FOUND);

		}
	}

	@Override
	public CandidateDTO getCandidateById(Long id) throws CandidateNotFoundByIdException {
		  Candidate candidate = candidateRepository.
				  findById(id).
				  orElseThrow(() -> new CandidateNotFoundByIdException("No Candidate Found For This Id "+id));
		  
		return (CandidateDTO) modelMapperImpl.convert(candidate, CandidateDTO.class);
	}

	@Override
	public void deleteCandidateById(Long id) throws CandidateNotFoundByIdException {
		getCandidateById(id);
		candidateRepository.deleteById(id);

	}

	@Override
	public CandidateDTO save(CandidateDTO candidateDTO) throws CandidateNotSaveException {
		try {
			Candidate convert = (Candidate) modelMapperImpl.convert(candidateDTO, Candidate.class);
			if(convert.getId()==null) {
				convert.setId(candidateRepository.getMaxId()+1);
			}
			Candidate save = candidateRepository.save(convert);
			return (CandidateDTO) modelMapperImpl.convert(save, CandidateDTO.class);
		} catch (Exception stex) {
			throw new CandidateNotSaveException(CANDIDATE_FAIL_TO_SAVE);
		}

	}

	@Override
	public CandidateDTO update(CandidateDTO candidateDTO)
			throws CandidateNotFoundByIdException, CandidateNotSaveException {
		getCandidateById(candidateDTO.getId());
		return save(candidateDTO);
	}

}
