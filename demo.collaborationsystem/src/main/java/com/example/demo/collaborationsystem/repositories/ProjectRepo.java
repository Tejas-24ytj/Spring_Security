package com.example.demo.collaborationsystem.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.collaborationsystem.entities.Project;

public interface ProjectRepo extends JpaRepository<Project,Long>{

	@Query("SELECT p FROM Project p JOIN  p.employee e WHERE e.employeeName = :employeeName")
	Set<Project> findProjectsByEmployee(String employeeName);
	
}
