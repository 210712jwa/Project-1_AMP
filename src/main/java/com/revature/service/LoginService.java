package com.revature.service;

import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.exception.BadParameterException;
import com.revature.exception.InvalidLoginException;
import com.revature.model.User;

public class LoginService {
	
	LoginDAO userDao; //User Data Access Object
	
	
	public LoginService() {
		this.userDao = new LoginDAOImpl();
	}

	public User loginInfo(String username, String password) throws InvalidLoginException, BadParameterException {
		
		if (username.trim().equals("") && password.trim().equals("")) {
			throw new BadParameterException("Username and password must be filled");
		}
		
		if (username.trim().equals("")) {
			throw new InvalidLoginException("The username must be filled.");
		}
		
		if (password.trim().equals("")) {
			throw new InvalidLoginException("The password must be filled.");
		}
		
		User user = userDao.getUserInfo(username, password);
		
//		if (user == null) {
//			throw new InvalidLoginException("Either the username or password entered are invalid.\n" + username + "\n" + password);
//			
//		}
		
		return user;
	}
	
}
