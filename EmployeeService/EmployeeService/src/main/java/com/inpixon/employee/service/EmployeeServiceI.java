package com.inpixon.employee.service;

import java.util.List;

import com.inpixon.employee.dto.EmployeeDTO;
import com.inpixon.employee.exception.EmployeeNotFoundException;
import com.inpixon.employee.exception.EmployeeNotSaveException;
import com.inpixon.employee.exception.EmployeeNotfoundByIdException;

public interface EmployeeServiceI {
	public List<EmployeeDTO> getAllEmployees() throws EmployeeNotFoundException;
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) throws EmployeeNotSaveException;
	public EmployeeDTO  getEmployeeById(Long id) throws EmployeeNotfoundByIdException;
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO ) throws EmployeeNotfoundByIdException, EmployeeNotSaveException;
	public void deleteEmployeeById(Long id) throws EmployeeNotfoundByIdException;

}
