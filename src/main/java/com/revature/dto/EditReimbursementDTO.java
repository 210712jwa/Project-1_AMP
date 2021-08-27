package com.revature.dto;

import java.util.Objects;

public class EditReimbursementDTO {
	private int statusID;

	public EditReimbursementDTO() {
		super();
	}

	public EditReimbursementDTO(int statusID) {
		super();
		this.statusID = statusID;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(statusID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EditReimbursementDTO other = (EditReimbursementDTO) obj;
		return statusID == other.statusID;
	}

	@Override
	public String toString() {
		return "EditReimbursementDTO [statusID=" + statusID + "]";
	}
	
	
}
