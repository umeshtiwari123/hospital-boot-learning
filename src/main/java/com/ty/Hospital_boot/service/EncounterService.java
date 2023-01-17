package com.ty.Hospital_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital_boot.dao.EncounterDao;
import com.ty.Hospital_boot.dto.Encounter;
import com.ty.Hospital_boot.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	EncounterDao encounterDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(encounterDao.saveEncounter(encounter));

		ResponseEntity<ResponseStructure<Encounter>> responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int id) {
		Encounter encounter2 = encounterDao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();

		if (encounter2 != null) {
			encounter.setAdmitionId(id);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(encounterDao.updateEncounter(encounter2, id));
		}

		else {
			return null;
		}
		ResponseEntity<ResponseStructure<Encounter>> responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();

		Encounter encounter = encounterDao.getEncounterById(id);

		if (encounter != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(encounterDao.getEncounterById(id));
		}
		else {
			return null;
		}
		
		ResponseEntity<ResponseStructure<Encounter>> responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;

	}
	
	public ResponseEntity<ResponseStructure<String>> deleteEncounterById(int id) {
		Encounter encounter=encounterDao.getEncounterById(id);
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		if(encounter!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("delete");
			responseStructure.setData(encounterDao.deleteById(id));
		}
		
		else {
			return null;
		}
		
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

}
