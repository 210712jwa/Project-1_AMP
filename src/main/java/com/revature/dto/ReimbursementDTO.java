package com.revature.dto;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

import com.revature.model.ReimbStatus;
import com.revature.model.ReimbType;
import com.revature.model.User;

public class ReimbursementDTO {
	
	private int reimbId;
	
	private double reimbAmount;
	
	private User author;
	
	private ReimbStatus statusID;
	
	private ReimbType typeID;
	
	private Timestamp submitTime;
	
	private Timestamp resolveTime;
	
	private Blob receipt;
	
	public ReimbursementDTO() {
		super();
	}
	
	public ReimbursementDTO(double reimbAmount, User author) {
		super();
		this.reimbAmount = reimbAmount;
		this.author = author;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
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
		return Objects.hash(author, receipt, reimbAmount, reimbId, resolveTime, statusID, submitTime, typeID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementDTO other = (ReimbursementDTO) obj;
		return Objects.equals(author, other.author) && Objects.equals(receipt, other.receipt)
				&& Double.doubleToLongBits(reimbAmount) == Double.doubleToLongBits(other.reimbAmount)
				&& reimbId == other.reimbId && Objects.equals(resolveTime, other.resolveTime)
				&& Objects.equals(statusID, other.statusID) && Objects.equals(submitTime, other.submitTime)
				&& Objects.equals(typeID, other.typeID);
	}

	@Override
	public String toString() {
		return "ReimbursementDTO [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", author=" + author
				+ ", statusID=" + statusID + ", typeID=" + typeID + ", submitTime=" + submitTime + ", resolveTime="
				+ resolveTime + ", receipt=" + receipt + "]";
	}
	
	
}
