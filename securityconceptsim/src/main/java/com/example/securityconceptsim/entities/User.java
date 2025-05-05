package com.example.securityconceptsim.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String username;
	private String email;

	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	Set<Role> roles = new HashSet<>();

	public User(Long userId, String username, String email, Set<Role> roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
	public User(Long userId, String username, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String email, Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + "]";
	}
	
	

}
