package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.dto.AddReimbursementDTO;
import com.revature.model.ReimbStatus;
import com.revature.model.ReimbType;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.model.UserRole;

public class PopulateData {
	public static void main(String[] args) {
		populate_Status_Type_Role();
		addSampleUsers();
		addSampleReimbursements();
	}
	
	private static void populate_Status_Type_Role() {
		SessionFactory sf = SessionUtility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		UserRole manager = new UserRole("manager");
		UserRole employee = new UserRole("employee");
		session.persist(manager);
		session.persist(employee);
		
		ReimbStatus pending = new ReimbStatus("pending");
		ReimbStatus approved = new ReimbStatus("approved");
		ReimbStatus denied = new ReimbStatus("denied");
		session.persist(pending);
		session.persist(approved);
		session.persist(denied);
		
		ReimbType lodging = new ReimbType("lodging");
		ReimbType travel = new ReimbType("travel");
		ReimbType food = new ReimbType("food");
		ReimbType other = new ReimbType("other");
		
		session.persist(lodging);
		session.persist(travel);
		session.persist(food);
		session.persist(other);
		
		tx.commit();
		session.close();
	}
	
	private static void addSampleUsers() {
		SessionFactory sf = SessionUtility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User employee1 = new User("employee1@yuh.com", "employee1", "greasemonkey24", "Ky", "Kiske");
		User employee2 = new User("employee2@yuh.com", "employee2", "glockinmyrari12", "Millia", "Rage");
		User employee3 = new User("employee3@yuh.com", "employee3", "yaters32", "Axl", "Low");
		User admin = new User("adminMan@yuh.com", "admin", "wuhtusay15", "Leo", "Whitefang");
		
		UserRole manager = (UserRole) session.createQuery("FROM UserRole ur WHERE ur.role = 'manager'").getSingleResult();
		UserRole employee = (UserRole) session.createQuery("FROM UserRole ur WHERE ur.role = 'employee'").getSingleResult();
		
		employee1.setUserRole(employee);
		employee2.setUserRole(employee);
		employee3.setUserRole(employee);
		admin.setUserRole(manager);
		
		session.persist(employee1);
		session.persist(employee2);
		session.persist(employee3);
		session.persist(admin);
		
		tx.commit();
		session.close();
	}
	
	private static void addSampleReimbursements() {
		SessionFactory sf = SessionUtility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User employee1 = (User) session.createQuery("FROM User WHERE username = 'employee1'").getSingleResult();
		User employee2 = (User) session.createQuery("FROM User WHERE username = 'employee2'").getSingleResult();
		User employee3 = (User) session.createQuery("FROM User WHERE username = 'employee3'").getSingleResult();
		User admin = (User) session.createQuery("FROM User WHERE username = 'admin'").getSingleResult();
		
		ReimbStatus pending = (ReimbStatus) session.createQuery("FROM ReimbStatus WHERE status = 'pending'").getSingleResult();
		
		ReimbType lodging = (ReimbType) session.createQuery("FROM ReimbType WHERE type = 'lodging'").getSingleResult();
		ReimbType travel = (ReimbType) session.createQuery("FROM ReimbType WHERE type = 'travel'").getSingleResult();
		ReimbType food = (ReimbType) session.createQuery("FROM ReimbType WHERE type = 'food'").getSingleResult();
		ReimbType other = (ReimbType) session.createQuery("FROM ReimbType WHERE type = 'other'").getSingleResult();
		
		Reimbursement reimb1 = new Reimbursement(125.20, employee1);
		reimb1.setStatusID(pending);
		reimb1.setTypeID(lodging);
//		reimb1.setResolver(null);
		
		Reimbursement reimb2 = new Reimbursement(580.90, employee2);
		reimb2.setStatusID(pending);
		reimb2.setTypeID(lodging);
//		reimb2.setResolver(null);
		
		Reimbursement reimb3 = new Reimbursement(2000.40, employee3);
		reimb3.setStatusID(pending);
		reimb3.setTypeID(travel);
//		reimb3.setResolver(null);
		
		Reimbursement reimb4 = new Reimbursement(13.20, employee1);
		reimb4.setStatusID(pending);
		reimb4.setTypeID(food);
//		reimb4.setResolver(null);
		
		Reimbursement reimb5 = new Reimbursement(60.40, employee1);
		reimb5.setStatusID(pending);
		reimb5.setTypeID(other);
//		reimb5.setResolver(null);
		
		session.persist(reimb1);
		session.persist(reimb2);
		session.persist(reimb3);
		session.persist(reimb4);
		session.persist(reimb5);
		
		tx.commit();
		session.close();
	}
}
