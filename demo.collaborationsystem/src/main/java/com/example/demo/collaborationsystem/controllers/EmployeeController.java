package com.example.demo.collaborationsystem.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.collaborationsystem.entities.Employee;
import com.example.demo.collaborationsystem.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	EmployeeService empService;

	@Autowired
	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	    return ResponseEntity.status(HttpStatus.CREATED).body(empService.createEmployee(employee));
	}
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.status(HttpStatus.OK).body(empService.getAllEmployees());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long employeeId){
		return ResponseEntity.status(HttpStatus.OK).body(empService.getEmployee(employeeId));
	}
	@PostMapping("/{projectId}/assign/{employeeId}")
	public ResponseEntity<Void> enrollEmployee(@PathVariable("projectId") Long projectId, @PathVariable("employeeId") Long employeeId){
		empService.enrollEmployee(employeeId, projectId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/getemployee/{id}")
	public ResponseEntity<List<Employee>> findEmployeeByProject(@PathVariable("id") String projectName){
		return ResponseEntity.status(HttpStatus.OK).body(empService.findEmployeesByProject(projectName));
	}
}
