package com.example.securityconceptsim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.securityconceptsim.entities.User;

public interface UserRepo extends JpaRepository<User,Long>{
	@Query("SELECT u FROM User u JOIN u.roles r WHERE r.roleName = :roleName")
	List<User> findUsersByRoleName(String roleName);
	
	User findByUsername(String username);


}
