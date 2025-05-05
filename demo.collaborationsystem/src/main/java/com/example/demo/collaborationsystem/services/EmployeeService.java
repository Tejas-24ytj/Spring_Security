package com.example.demo.collaborationsystem.services;

import java.util.List;

import com.example.demo.collaborationsystem.entities.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee emp);

	List<Employee> getAllEmployees();

	Employee getEmployee(Long employeeId);

	void enrollEmployee(Long employeeId, Long projectId);

	List<Employee> findEmployeesByProject(String projectNames);

}
