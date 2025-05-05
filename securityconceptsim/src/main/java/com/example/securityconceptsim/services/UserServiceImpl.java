package com.example.securityconceptsim.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.securityconceptsim.entities.Role;
import com.example.securityconceptsim.entities.User;
import com.example.securityconceptsim.repositories.RoleRepo;
import com.example.securityconceptsim.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	UserRepo userRepo;
    RoleRepo  roleRepo;
	@Autowired
	public UserServiceImpl(UserRepo userRepo,RoleRepo roleRepo) {
		super();
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUserById(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Student Not Found."));
		userRepo.delete(user);
		
	}
	@Override
	public User assignRoleToUser(Long userId, Long roleId) {
	    User user = userRepo.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));
	    Role role = roleRepo.findById(roleId)
	            .orElseThrow(() -> new RuntimeException("Role not found"));

	    user.getRoles().add(role);
	    return userRepo.save(user);
	}

	@Override
	public List<User> getUsersByRole(String roleName) {
	    return userRepo.findUsersByRoleName(roleName);
	}
	
	@Override
	public Set<Role> getRolesByUsername(String userName) {
	    User user = userRepo.findByUsername(userName);
	    if (user == null) {
	        throw new RuntimeException("User not found with username: " + userName);
	    }
	    return user.getRoles();
	}


	
	

}
