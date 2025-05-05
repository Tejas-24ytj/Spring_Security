package com.example.demo.collaborationsystem.services;

import java.util.List;
import java.util.Set;

import com.example.demo.collaborationsystem.entities.Project;

public interface ProjectService {
	
	Project createProject(Project project);

	
     List<Project> getAllProject();
	
	Project getProject(Long projectId);
	
	Set<Project> findProjectsByEmployee(String employeeName);
}
