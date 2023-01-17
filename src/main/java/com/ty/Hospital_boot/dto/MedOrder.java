package com.ty.Hospital_boot.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MedOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String priscription_name;
	private int numbers;
	private String duration;
	private double totalprice;

	@OneToMany(cascade = CascadeType.ALL)
	private List<MedItems> medItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriscription_name() {
		return priscription_name;
	}

	public void setPriscription_name(String priscription_name) {
		this.priscription_name = priscription_name;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public List<MedItems> getMedItems() {
		return medItems;
	}

	public void setMedItems(List<MedItems> medItems) {
		this.medItems = medItems;
	}

}
