package com.example.demo.collaborationsystem.entities;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long projectId;
	private String projectName;
	private String description;
	@JsonIgnore
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees;
	public Project() {
		super();
	}
	public Project(Long projectId, String projectName, String description, Set<Employee> employees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.employees = employees;
	}
	public Project(Long projectId, String projectName, String description) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", description=" + description
				+ ", employees=" + employees + "]";
	}
	

}
