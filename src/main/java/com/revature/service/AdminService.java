package com.revature.service;

import javax.servlet.http.HttpSession;

import com.revature.dto.MessageDTO;
import com.revature.exception.NotAuthorizedException;
import com.revature.model.User;

import io.javalin.http.Context;

public class AdminService {
	
	public void guard(Context ctx) throws NotAuthorizedException {
		HttpSession session = ctx.req.getSession();
		
		User loggedUser = (User) session.getAttribute("loggedInUser");
		
		if (loggedUser.getUserRole().getRoleID() != 1) {
			throw new NotAuthorizedException("You are not allowed to access this controller.");
		}
		
	}
}
