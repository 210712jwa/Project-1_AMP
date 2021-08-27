package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dto.AddReimbursementDTO;
import com.revature.dto.EditReimbursementDTO;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class ReimbursementService {
	
	private ReimbursementDAO reimbDao;
	
	public ReimbursementService() {
		this.reimbDao = new ReimbursementDAO();
	}
	
	public List<Reimbursement> getAllReimbursementsByUserId(String userID) {
		
		int user_id = Integer.parseInt(userID);
		
		List<Reimbursement> reimbs = reimbDao.getAllReimbursementsById(user_id);
		
		return reimbs;
	}

	public Reimbursement addReimbursement(AddReimbursementDTO reimbursementDto, String userID) {
		
		int user_id = Integer.parseInt(userID);
		
		Reimbursement reimb = reimbDao.addReimb(reimbursementDto, user_id);
		
		return reimb;
	}

	public List<Reimbursement> getAllReimbursements() {
		
		List<Reimbursement> reimbs = reimbDao.getAllReimbursements();
		return reimbs;
	}

	public Reimbursement resolveReimbursement(EditReimbursementDTO reimbursementDto, String reimbID, User loggedUser) {
		
		int reimb_id = Integer.parseInt(reimbID);		
		Reimbursement reimb = reimbDao.resolveReimb(reimbursementDto, reimb_id, loggedUser);
		
		return reimb;
	}

	public List<Reimbursement> filterByStatus(String statusID) {
		
		int status_id = Integer.parseInt(statusID);
		
		List<Reimbursement> reimbs = reimbDao.filterReimbs(status_id);
		return reimbs;
	}
	
	
}
