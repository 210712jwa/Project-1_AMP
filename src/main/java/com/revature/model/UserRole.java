package com.revature.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int roleID;
	
	@Column
	private String role;
	
	
	public UserRole() {
		super();
	}

	public UserRole(String role) {
		super();
		this.role = role;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(role, roleID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return Objects.equals(role, other.role) && roleID == other.roleID;
	}

	@Override
	public String toString() {
		return "UserRole [roleID=" + roleID + ", role=" + role + "]";
	}
	
	
	
}
