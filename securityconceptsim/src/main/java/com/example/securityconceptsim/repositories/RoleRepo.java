package com.example.securityconceptsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityconceptsim.entities.Role;

public interface RoleRepo extends JpaRepository<Role,Long>{

}
