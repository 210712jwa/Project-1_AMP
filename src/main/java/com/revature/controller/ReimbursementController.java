package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dto.MessageDTO;
import com.revature.dto.ReimbursementDTO;
import com.revature.model.User;
import com.revature.service.ReimbursementService;
import com.revature.model.Reimbursement;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbursementController implements Controller {
	
	private ReimbursementService reimbService;
	
	public ReimbursementController() {
		this.reimbService = new ReimbursementService();
	}
	
	private Handler getAllEmployeeReimbursements = (ctx) -> {
		HttpSession session = ctx.req.getSession();
		
		if (session.getAttribute("loggedInUser") == null) {
			ctx.json(new MessageDTO("You need to be logged in to perform this action"));
		} else {
			User loggedInUser = (User) session.getAttribute("loggedInUser");
			
			String userID = ctx.pathParam("userID");
			
			if (loggedInUser.getUserID() == Integer.parseInt(userID)) {
				List<ReimbursementDTO> reimbs = reimbService.getAllReimbursementsByUserId(userID);
				
				ctx.json(reimbs);
				ctx.status(200);
			} else {
				ctx.json(new MessageDTO("You are not the user that corresponds to the reimbursements retrieved."));
				ctx.status(401);
			}
		}
	};

	@Override
	public void mapEndpoints(Javalin app) {
		// TODO Auto-generated method stub
		app.get("/User/:userID/Reimbursement", getAllEmployeeReimbursements);
	}
	
}
