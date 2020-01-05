package com.inpixon.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inpixon.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	@Query("SELECT coalesce(max(eh.id), 0) FROM  Employee eh")
	Long getMaxId();
	
}
