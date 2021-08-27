package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dto.EditReimbursementDTO;
import com.revature.dto.MessageDTO;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.AdminService;
import com.revature.service.ReimbursementService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AdminController implements Controller {
	
	private ReimbursementService reimbService;
	private AdminService adminService;
	
	public AdminController() {
		this.reimbService = new ReimbursementService();
		this.adminService = new AdminService();
	}
	
	private Handler getAllReimbursements = (ctx) -> {
		HttpSession session = ctx.req.getSession();
		
		adminService.guard(ctx);
		
		if (session.getAttribute("loggedInUser") == null) {
			ctx.json(new MessageDTO("You need to be logged in to perform this action"));
		} else {
			User loggedInUser = (User) session.getAttribute("loggedInUser");
			
//			String userID = ctx.pathParam("userID");
			
//			if (loggedInUser.getUserID() == Integer.parseInt(userID)) {
				List<Reimbursement> reimbs = reimbService.getAllReimbursements();
				
				ctx.json(reimbs);
				ctx.status(200);
//			}
		}
	};
	
	private Handler resolveReimbursement = (ctx) -> {
		
		HttpSession session = ctx.req.getSession();
		
		adminService.guard(ctx);
		
		EditReimbursementDTO reimbursementDto = ctx.bodyAsClass(EditReimbursementDTO.class);
				
		User loggedUser = (User) session.getAttribute("loggedInUser");
		
		String reimbID = ctx.pathParam("reimbID");	
		
		if (session.getAttribute("loggedInUser") != null) {
			
			Reimbursement resolvedReimb = reimbService.resolveReimbursement(reimbursementDto, reimbID, loggedUser);
			
			if (resolvedReimb == null) {
				ctx.json(new MessageDTO("This reimbursement could not be resolved."));
				ctx.status(400);
			}
			
			else {
				ctx.json(resolvedReimb);
				ctx.json(new MessageDTO("The reimbursement has been resolved."));
				ctx.status(200);
			}
		} else {
			ctx.json(new MessageDTO("You need to be logged in to perform this action"));
		}
		
	};
	
	private Handler orderByPending = (ctx) -> {
		HttpSession session = ctx.req.getSession();
		
		adminService.guard(ctx);
		
		if (session.getAttribute("loggedInUser") == null) {
			ctx.json(new MessageDTO("You need to be logged in to perform this action."));
		} else {
			
			User loggedUser = (User) session.getAttribute("loggedInUser");
			String statusID = ctx.pathParam("statusID");
			
			List<Reimbursement> filteredReimbs = reimbService.filterByStatus(statusID);
			
			if (filteredReimbs == null) {
				ctx.json(400);
				ctx.json(new MessageDTO("The filtering did not work properly."));
			} else {
				ctx.json(200);
				ctx.json(filteredReimbs);
//				ctx.json(new MessageDTO("Filtering complete."));
			}
		}
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		// TODO Auto-generated method stub
		app.get("/Reimbursement", getAllReimbursements);
		app.patch("/Reimbursement/:reimbID/ReimbStatus", resolveReimbursement);
		app.get("Reimbursement/ReimbStatus/:statusID", orderByPending);
	}

}
