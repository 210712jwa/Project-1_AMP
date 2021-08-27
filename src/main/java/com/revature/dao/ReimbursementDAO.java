package com.revature.dao;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.dto.AddReimbursementDTO;
import com.revature.dto.EditReimbursementDTO;
import com.revature.model.ReimbStatus;
import com.revature.model.ReimbType;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.SessionUtility;

public class ReimbursementDAO {

	public List<Reimbursement> getAllReimbursementsById(int userId) {

		SessionFactory sf = SessionUtility.getSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		List<Reimbursement> bursements = (List<Reimbursement>) session
				.createQuery("SELECT r FROM Reimbursement r JOIN r.author a WHERE a.userID = :user")
				.setParameter("user", userId).getResultList();

		return bursements;
	}

	public Reimbursement addReimb(AddReimbursementDTO reimbursementDto, int user_id) {

		SessionFactory sf = SessionUtility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Date date = new Date();

		Timestamp submitTime = new Timestamp(date.getTime());

		Reimbursement reimb = new Reimbursement();

		reimb.setAuthor(session.get(User.class, user_id));

		reimb.setTypeID(session.get(ReimbType.class, reimbursementDto.getTypeID()));

		reimb.setReimbAmount(reimbursementDto.getReimbAmount());

		reimb.setStatusID(session.get(ReimbStatus.class, 1));

		reimb.setSubmitTime(submitTime);

		session.persist(reimb);
		tx.commit();
		session.close();

		return reimb;

	}

	public Reimbursement resolveReimb(EditReimbursementDTO reimbursementDto, int reimb_id, User loggedUser) {

		SessionFactory sf = SessionUtility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Reimbursement resolved = session.get(Reimbursement.class, reimb_id);

		Date date = new Date();

		Timestamp resolveTime = new Timestamp(date.getTime());

		resolved.setStatusID(session.get(ReimbStatus.class, reimbursementDto.getStatusID()));
		resolved.setResolveTime(resolveTime);
		resolved.setResolver(loggedUser);

		session.saveOrUpdate(resolved);
		tx.commit();
		session.close();

		return resolved;
	}

	public List<Reimbursement> getAllReimbursements() {

		SessionFactory sf = SessionUtility.getSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		List<Reimbursement> allReimbs = (List<Reimbursement>) session.createQuery("SELECT u FROM Reimbursement u")
				.getResultList();

		return allReimbs;
	}

	public List<Reimbursement> filterReimbs(int statusID) {

		SessionFactory sf = SessionUtility.getSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		List<Reimbursement> filteredReimbs = (List<Reimbursement>) session
				.createQuery("SELECT r FROM Reimbursement r JOIN r.status s WHERE s.statusID = :statusID")
				.setParameter("statusID", statusID).getResultList();

		return filteredReimbs;
	}
}
