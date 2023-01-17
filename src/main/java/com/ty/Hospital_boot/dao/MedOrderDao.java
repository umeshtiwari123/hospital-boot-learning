package com.ty.Hospital_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital_boot.dto.MedOrder;
import com.ty.Hospital_boot.repository.MedOrderRepo;

@Repository
public class MedOrderDao {

	@Autowired
	MedOrderRepo repo;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return repo.save(medOrder);
	}

	public MedOrder updateMedOreMedOrder(MedOrder medOrder) {
		return repo.save(medOrder);
	}

	public MedOrder findmedorderbyid(int id) {
		Optional<MedOrder> optional = repo.findById(id);
		if (optional.isPresent()) {
		return optional.get();
		}
		return null;
	}

	public String deleteMedOrder(int id) {
		 repo.deleteById(id);
		 return "deleted";
	}

}
