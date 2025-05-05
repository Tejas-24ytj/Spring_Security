package com.example.demo.collaborationsystem.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.collaborationsystem.entities.Project;
import com.example.demo.collaborationsystem.services.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}

	@PostMapping
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(project));
	}

	@GetMapping
	public ResponseEntity<List<Project>> getAllProjects() {
		return ResponseEntity.status(HttpStatus.OK).body(projectService.getAllProject());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Project> getProject(@PathVariable("id") Long projectId) {
		return ResponseEntity.status(HttpStatus.OK).body(projectService.getProject(projectId));
	}

	@GetMapping("/employee/{employeeName}")
	public ResponseEntity<Set<Project>> getProjectByEmployee(@PathVariable("employeeName") String employeeName) {
		return ResponseEntity.status(HttpStatus.OK).body(projectService.findProjectsByEmployee(employeeName));
	}

}
