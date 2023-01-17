package com.ty.Hospital_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital_boot.dao.MedItemsDao;
import com.ty.Hospital_boot.dto.MedItems;
import com.ty.Hospital_boot.util.ResponseStructure;

@Service
public class MedItemsService {

	@Autowired
	MedItemsDao dao;

	public ResponseEntity<ResponseStructure<MedItems>> serviceupdateMedItems(MedItems medItems, int id) {
		ResponseStructure<MedItems> responseStructure = new ResponseStructure<MedItems>();
		MedItems medItems2 = dao.findmeditemsbyid(id);
		if (medItems2 != null) {
			medItems.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("MedItems Updated ");
			responseStructure.setData(dao.updateMedItems(medItems));
			ResponseEntity<ResponseStructure<MedItems>> entity = new ResponseEntity<ResponseStructure<MedItems>>(
					responseStructure, HttpStatus.OK);
			return entity;
		} else
			return null;
	}

	public ResponseEntity<ResponseStructure<MedItems>> servicefindbyid(int id) {
		ResponseStructure<MedItems> responseStructure = new ResponseStructure<MedItems>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage(" Found Medorder");
		responseStructure.setData(dao.findmeditemsbyid(id));
		return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure,HttpStatus.FOUND);
	}

}
