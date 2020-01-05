package com.inpixon.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inpixon.employee.dto.EmployeeDTO;
import com.inpixon.employee.entity.Employee;
import com.inpixon.employee.exception.EmployeeNotFoundException;
import com.inpixon.employee.exception.EmployeeNotSaveException;
import com.inpixon.employee.exception.EmployeeNotfoundByIdException;
import com.inpixon.employee.repository.EmployeeRepository;
import com.inpixon.employee.util.ModelMapperImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Repository
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapperImpl modelMapperImpl;

	@Override
	@HystrixCommand(fallbackMethod="getAllEmployeeFallback")
	public List<EmployeeDTO> getAllEmployees() throws EmployeeNotFoundException {
		try {
			List<Employee> findAll = employeeRepository.findAll();
			if (CollectionUtils.isEmpty(findAll)) {
				return new ArrayList<>();
			}
			/*if(RandomUtils.nextBoolean()) {
				throw new RuntimeException("Failed");
			}*/
			return findAll.stream().map(employee -> (EmployeeDTO) modelMapperImpl.convert(employee, EmployeeDTO.class))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new EmployeeNotFoundException("no employees found");
		}
	}
	
	
	public List<EmployeeDTO> getAllEmployeeFallback(){
		EmployeeDTO emp= new EmployeeDTO(000L, "xxxxx", "yyyyy", "uuuuu", -11);
		List<EmployeeDTO> list= new ArrayList<>();
		list.add(emp);
		return list;
	}

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) throws EmployeeNotSaveException {
		try {
		Employee employee = (Employee)modelMapperImpl.convert(employeeDTO, Employee.class);
		if(employee.getId()==null) {
			employee.setId(employeeRepository.getMaxId()+1);
		}
		Employee saveEmployee = employeeRepository.save(employee);
		return(EmployeeDTO)modelMapperImpl.convert(saveEmployee, EmployeeDTO.class);
		
	}catch(Exception etex) {
		throw new EmployeeNotSaveException("employee failed to save");
	}
		
	}

	@Override
	public EmployeeDTO getEmployeeById(Long id) throws EmployeeNotfoundByIdException {

		Employee employee = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotfoundByIdException("no candidate is found for the given id"));
		return (EmployeeDTO) modelMapperImpl.convert(employee, EmployeeDTO.class);

		

	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws EmployeeNotfoundByIdException, EmployeeNotSaveException {
		
		getEmployeeById(employeeDTO.getId());
		return saveEmployee(employeeDTO);
	}

	@Override
	public void deleteEmployeeById(Long id) throws EmployeeNotfoundByIdException {
		getEmployeeById(id);
		employeeRepository.deleteById(id);
	}

}