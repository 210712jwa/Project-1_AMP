package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReimbStatus {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private int statusID;
	
	@Column
	private String status;
	
	public ReimbStatus() {
		super();
	}

	public ReimbStatus(String status) {
		super();
		this.status = status;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, statusID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbStatus other = (ReimbStatus) obj;
		return Objects.equals(status, other.status) && statusID == other.statusID;
	}

	@Override
	public String toString() {
		return "ReimbStatus [statusID=" + statusID + ", status=" + status + "]";
	}
	
	
}
