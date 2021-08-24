package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReimbType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int typeId;
	
	@Column
	private String type;
	
	public ReimbType() {
		super();
	}

	public ReimbType(String type) {
		super();
		this.type = type;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, typeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbType other = (ReimbType) obj;
		return Objects.equals(type, other.type) && typeId == other.typeId;
	}

	@Override
	public String toString() {
		return "ReimbType [typeId=" + typeId + ", type=" + type + "]";
	}
	
	
}
