package com.revature.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.Table;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private int userID;
	
	@Column (name = "Email", nullable = false, unique = true)
	private String userEmail;
	
	@Column (name = "username", nullable = false, unique = true)
	private String username;
	
	@Column (name = "password", nullable = false)
	private String password;
	
	@Column (name = "first_name", nullable = false)
	private String firstName;
	
	@Column (name = "last_name", nullable = false)
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name = "role_ID")
	UserRole userRole;
	
	public User() {
		super();
	}

	public User(String userEmail, String username, String password, String firstName,
			String lastName) {
		super();
		this.userEmail = userEmail;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}
	
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, password, userEmail, userID, userRole, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(userEmail, other.userEmail)
				&& userID == other.userID && Objects.equals(userRole, other.userRole)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userEmail=" + userEmail + ", username=" + username + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", userRole=" + userRole + "]";
	}

	
	
	
	
	
	
}
