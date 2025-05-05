package com.example.securityconceptsim.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securityconceptsim.entities.Role;
import com.example.securityconceptsim.entities.User;
import com.example.securityconceptsim.services.UserService;

@RestController
@RequestMapping("/api/users")

public class UserController {
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<User> deleteUserById(@PathVariable Long userId) {
		userService.deleteUserById(userId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@GetMapping("/role/{roleName}")
	public ResponseEntity<List<User>> getUsersByRole(@PathVariable String roleName) {
	    return ResponseEntity.ok(userService.getUsersByRole(roleName));
	}
	
	@PostMapping("/{userId}/addRole/{roleId}")
	public ResponseEntity<User> assignRoleToUser(@PathVariable Long userId, @PathVariable Long roleId) {
	    User updatedUser = userService.assignRoleToUser(userId, roleId);
	    return ResponseEntity.ok(updatedUser);
	}
	@GetMapping("/role/user/{username}")
	public ResponseEntity<Set<Role>> getRolesForUser(@PathVariable String username) {
	    return ResponseEntity.ok(userService.getRolesByUsername(username));
	}




}
