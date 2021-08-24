package com.revature.controller;

import javax.servlet.http.HttpSession;

import com.revature.dto.MessageDTO;
import com.revature.dto.UserLoginDTO;
import com.revature.model.User;
import com.revature.service.LoginService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class LoginController implements Controller {
	
	private LoginService loginService;
	
	public LoginController() {
		this.loginService = new LoginService();
	}
	
	private Handler loginHandler = (ctx) -> {
		UserLoginDTO userLoginDTO = ctx.bodyAsClass(UserLoginDTO.class);
		
		System.out.println(userLoginDTO.toString());
		
		User user = loginService.loginInfo(userLoginDTO.getUsername(), userLoginDTO.getPassword());
		
		System.out.println("This is to show the we're back at the handler.");
		
		if (user == null) {
			ctx.json(new MessageDTO("The entered user could not be found in the database."));
			ctx.status(400);
		}
		
		else {
		HttpSession httpSession = ctx.req.getSession();
		httpSession.setAttribute("loggedInUser", user);
		
		ctx.json(user);
		ctx.status(200);
		}
	};
	
	private Handler loggedInUserHandler = (ctx) -> {
		HttpSession httpSession = ctx.req.getSession();
		if (httpSession.getAttribute("loggedInUser") == null) {
			ctx.json(new MessageDTO("User is currently not logged in"));
			ctx.status(401);
		} else {
			User user = (User) httpSession.getAttribute("loggedInUser");
			ctx.json(user);
			ctx.status(200);
		}
	};
	
	private Handler logoutHandler = (ctx) -> {
		
		if (ctx.sessionAttribute("loggedInUser") == null) {
			ctx.json(new MessageDTO("User is already logged out"));
			ctx.status(400);
		} else {
			ctx.req.getSession().invalidate();
			ctx.json(new MessageDTO("The user has been logged out."));
			ctx.status(200);
		}
	};

	@Override
	public void mapEndpoints(Javalin app) {
		// TODO Auto-generated method stub
		app.post("/login", loginHandler);
		app.get("loggedInUser", loggedInUserHandler);
		app.post("/logout", logoutHandler);
	}

}
