package com.revature.dao;

import com.revature.model.User;

public interface LoginDAO {
	
	public abstract User getUserInfo(String username, String password );
}
