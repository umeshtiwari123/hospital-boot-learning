package com.ty.Hospital_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital_boot.dto.Encounter;
import com.ty.Hospital_boot.repository.EncounterRepo;

@Repository
public class EncounterDao {
	
	@Autowired
	EncounterRepo encounterRepo;
	
	public Encounter saveEncounter(Encounter encounter) {
         return encounterRepo.save(encounter);		
		
	}
	public Encounter updateEncounter(Encounter encounter,int id) {
        return encounterRepo.save(encounter);		
		
	}
	public Encounter getEncounterById(int id) {
       Optional<Encounter> optional = encounterRepo.findById(id);
       if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
		
	}
	
	public String deleteById(int id) {
		 encounterRepo.existsById(id);
		 return "deleted";
		
	}

}
