package com.example.demo.collaborationsystem.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.collaborationsystem.entities.Employee;
import com.example.demo.collaborationsystem.entities.Project;
import com.example.demo.collaborationsystem.repositories.EmployeeRepo;
import com.example.demo.collaborationsystem.repositories.ProjectRepo;

@Service
public class ProjectServiceImpl implements ProjectService {

	ProjectRepo projectRepo;
	EmployeeRepo empRepo;

	@Autowired
	public ProjectServiceImpl(ProjectRepo projectRepo,EmployeeRepo empRepo) {
		super();
		this.projectRepo = projectRepo;
		this.empRepo=empRepo;
	}

	@Override
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}

	@Override
	public List<Project> getAllProject() {
		return projectRepo.findAll();
	}

	@Override
	public Project getProject(Long projectId) {
		return projectRepo.findById(projectId).orElseThrow(()-> new RuntimeException("Project with Id not Found "));
	}
	@Override
	public Set<Project> findProjectsByEmployee(String employeeName) {
		return projectRepo.findProjectsByEmployee(employeeName);
	}



	

}
