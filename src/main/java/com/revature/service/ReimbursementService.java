package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dto.ReimbursementDTO;
import com.revature.model.Reimbursement;

public class ReimbursementService {
	
	private ReimbursementDAO reimbDao;
	
	public ReimbursementService() {
		this.reimbDao = new ReimbursementDAO();
	}
	
	public List<ReimbursementDTO> getAllReimbursementsByUserId(String userID) {
		
		int user_id = Integer.parseInt(userID);
		
		List<ReimbursementDTO> reimbs = reimbDao.getAllReimbursementsById(user_id);
		
		return reimbs;
	}
}
