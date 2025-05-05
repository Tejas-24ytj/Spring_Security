package com.example.demo.collaborationsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.collaborationsystem.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	

	@Query("SELECT e FROM Employee e WHERE e.project.name = :projectName")
	List<Employee> findEmployeesByProject(@Param("projectName") String projectName);



	Employee getEmployeeByEmpId(Long empId);

}
