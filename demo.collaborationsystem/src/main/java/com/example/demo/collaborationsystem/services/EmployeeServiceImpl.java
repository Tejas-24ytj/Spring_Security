package com.example.demo.collaborationsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.collaborationsystem.entities.Employee;
import com.example.demo.collaborationsystem.entities.Project;
import com.example.demo.collaborationsystem.repositories.EmployeeRepo;
import com.example.demo.collaborationsystem.repositories.ProjectRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepo empRepo;
	ProjectRepo projRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepo empRepo,ProjectRepo projRepo) {
		this.empRepo = empRepo;
		this.projRepo = projRepo;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		return empRepo.findById(employeeId).orElseThrow(()->new RuntimeException("Employee with Id not Found "));
	}
	
	@Override
	public void enrollEmployee(Long employeeId, Long projectId) {
		Employee emp = empRepo.findById(employeeId).orElseThrow(()->new RuntimeException("Employee with Id not Found"));
		Project proj = projRepo.findById(projectId).orElseThrow(()-> new RuntimeException("Project with Id not Found"));
		
		for(Project p : emp.getProjects()) {
			if(p.getProjectId().equals(proj.getProjectId())) {
				throw new RuntimeException("Duplicate Project ID Found. Employee Already in Project");
			}
		}
		emp.getProjects().add(proj);
		proj.getEmployees().add(emp);
		empRepo.save(emp);
	}
	
	@Override
	public List<Employee> findEmployeesByProject(String projectNames) {
		return empRepo.findEmployeesByProject(projectNames);
	}

	
	
	

}
