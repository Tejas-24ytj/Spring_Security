package com.example.securityconceptsim.services;

import java.util.List;
import java.util.Set;

import com.example.securityconceptsim.entities.Role;
import com.example.securityconceptsim.entities.User;

public interface UserService {
	User createUser(User user);
	
	void deleteUserById(Long usertId);
	
	User assignRoleToUser(Long userId, Long roleId);
	
	List<User> getUsersByRole(String roleName);
	
	Set<Role> getRolesByUsername(String username);



}
