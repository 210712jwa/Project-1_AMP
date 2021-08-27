package com.revature.dto;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

import com.revature.model.ReimbStatus;
import com.revature.model.ReimbType;
import com.revature.model.User;

public class AddReimbursementDTO {
	
//	private int reimbId;
	
	private double reimbAmount;
	
//	private User author;
	
//	private int statusID;
	
	private int typeID;
	
	private String desc;
	
//	private Timestamp submitTime;
	
//	private Timestamp resolveTime;
	
//	private Blob receipt;
	
	public AddReimbursementDTO() {
		super();
	}
	
	public AddReimbursementDTO(double reimbAmount, int typeID, String desc) {
		super();
		this.reimbAmount = reimbAmount;
		this.typeID = typeID;
		this.desc = desc;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(desc, reimbAmount, typeID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddReimbursementDTO other = (AddReimbursementDTO) obj;
		return Objects.equals(desc, other.desc)
				&& Double.doubleToLongBits(reimbAmount) == Double.doubleToLongBits(other.reimbAmount)
				&& typeID == other.typeID;
	}

	@Override
	public String toString() {
		return "ReimbursementDTO [reimbAmount=" + reimbAmount + ", typeID=" + typeID + ", desc=" + desc + "]";
	}

	
	
}
