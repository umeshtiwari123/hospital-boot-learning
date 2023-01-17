package com.ty.Hospital_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital_boot.dto.MedItems;
import com.ty.Hospital_boot.repository.MedItemsRepo;

@Repository
public class MedItemsDao {

	@Autowired
	MedItemsRepo repo;

	public MedItems updateMedItems(MedItems medItems) {
		return repo.save(medItems);
	}

	public MedItems findmeditemsbyid(int id) {
		Optional<MedItems> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
