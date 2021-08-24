package com.revature.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reimbursement {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "reimb_ID")
	private int reimbID;
	
	@Column (name = "reimb_Amount")
	private double reimbAmount;
	
	@ManyToOne
	@JoinColumn (name = "author", nullable = false)
	private User author; // meant to join with the users table; should be a User object
	
	@ManyToOne
	@JoinColumn (name = "resolver")
	private User resolver; //meant to join with the users table; should be a User object
	
	@ManyToOne
	@JoinColumn (name = "status_id", nullable = false)
	private ReimbStatus statusID; //meant to join with the status table; should be an objecct
	
	@ManyToOne
	@JoinColumn (name = "type_id", nullable = false)
	private ReimbType typeID; // meant to join with the type table; should be an object
	
	@Column
	private Timestamp submitTime;
//	
	@Column
	private Timestamp resolveTime;
//	
	@Column
	private Blob receipt;
		
	public Reimbursement(){
		super();
	}

	public Reimbursement(double reimbAmount, User author) {
		super();
		this.reimbAmount = reimbAmount;
		this.author = author;
	}

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public ReimbStatus getStatusID() {
		return statusID;
	}

	public void setStatusID(ReimbStatus statusID) {
		this.statusID = statusID;
	}

	public ReimbType getTypeID() {
		return typeID;
	}

	public void setTypeID(ReimbType typeID) {
		this.typeID = typeID;
	}
	
	

	public Timestamp getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Timestamp getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(Timestamp resolveTime) {
		this.resolveTime = resolveTime;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, receipt, reimbAmount, reimbID, resolveTime, resolver, statusID, submitTime, typeID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Objects.equals(author, other.author) && Objects.equals(receipt, other.receipt)
				&& Double.doubleToLongBits(reimbAmount) == Double.doubleToLongBits(other.reimbAmount)
				&& reimbID == other.reimbID && Objects.equals(resolveTime, other.resolveTime)
				&& Objects.equals(resolver, other.resolver) && Objects.equals(statusID, other.statusID)
				&& Objects.equals(submitTime, other.submitTime) && Objects.equals(typeID, other.typeID);
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", reimbAmount=" + reimbAmount + ", author=" + author
				+ ", resolver=" + resolver + ", statusID=" + statusID + ", typeID=" + typeID + ", submitTime="
				+ submitTime + ", resolveTime=" + resolveTime + ", receipt=" + receipt + "]";
	}
	
}
