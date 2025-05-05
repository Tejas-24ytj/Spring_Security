package com.example.securityconceptsim.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securityconceptsim.entities.Role;
import com.example.securityconceptsim.repositories.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService {
	RoleRepo roleRepo;
	
	@Autowired
	public RoleServiceImpl(RoleRepo roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}
	

	@Override
	public Role createRole(Role role) {
		return roleRepo.save(role);
	}

	

}
