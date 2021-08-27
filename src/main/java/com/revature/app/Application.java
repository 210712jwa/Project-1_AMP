package com.revature.app;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

import com.revature.controller.AdminController;

//import java.sql.Connection;

import com.revature.controller.Controller;
import com.revature.controller.ExceptionController;
import com.revature.controller.LoginController;
import com.revature.controller.ReimbursementController;

import io.javalin.Javalin;

public class Application {
	
	private static Javalin app;
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();
		});
			
		mapControllers(new LoginController(), new ExceptionController(), new ReimbursementController(), new AdminController());
		
		app.start(5000);
		
		logger.info("Log received from {}", Application.class.getSimpleName());
	}
	
	private static void mapControllers(Controller ... controllers) {
		
		for (Controller c : controllers) {
			c.mapEndpoints(app);
		}
	}
	

}
