package com.example.securityconceptsim.controllers;

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

import com.example.securityconceptsim.entities.Role;
import com.example.securityconceptsim.services.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}
	@PostMapping
	public ResponseEntity<Role> createRole(@RequestBody Role role) {
		return ResponseEntity.status(HttpStatus.CREATED).body(roleService.createRole(role));
	}
	
	

	
	
	

}
