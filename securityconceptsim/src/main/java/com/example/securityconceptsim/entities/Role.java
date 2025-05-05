package com.example.securityconceptsim.entities;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	private String roleName;
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public Role(Long roleId, String roleName, Set<User> users) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.users = users;
	}

	public Role() {
		super();
	}

	public Role(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + "]";
	}

}
