package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.dto.ReimbursementDTO;
import com.revature.model.Reimbursement;
import com.revature.util.SessionUtility;

public class ReimbursementDAO {
	
	public List<ReimbursementDTO> getAllReimbursementsById(int userId) {
		
		SessionFactory sf = SessionUtility.getSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		List<ReimbursementDTO> bursements = (List<ReimbursementDTO>) session.createQuery("SELECT r FROM Reimbursement r JOIN r.author a WHERE a.userID = :user").setParameter("user", userId).getResultList();
		
		return bursements;
	}
}
