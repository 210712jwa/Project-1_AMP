package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.model.User;
import com.revature.util.SessionUtility;



public class LoginDAOImpl implements LoginDAO {

	@Override
	public User getUserInfo(String username, String password) { //Grabs all user info with the username and password.

		SessionFactory sf = SessionUtility.getSessionFactory();
		
		try (Session session = sf.openSession()) {
			User user = (User) session.createQuery("From User WHERE username = :username AND password = :password")
					.setParameter("username", username).setParameter("password", password).getSingleResult();
			
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}

}
