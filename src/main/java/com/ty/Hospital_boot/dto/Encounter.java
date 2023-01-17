package com.ty.Hospital_boot.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Encounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admitionId;
	@NotNull
	private String reson;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branch;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<MedOrder> medOrder;

	public int getAdmitionId() {
		return admitionId;
	}

	public void setAdmitionId(int admitionId) {
		this.admitionId = admitionId;
	}

	public String getReson() {
		return reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	public List<MedOrder> getMedOrder() {
		return medOrder;
	}

	public void setMedOrder(List<MedOrder> medOrder) {
		this.medOrder = medOrder;
	}

	
}