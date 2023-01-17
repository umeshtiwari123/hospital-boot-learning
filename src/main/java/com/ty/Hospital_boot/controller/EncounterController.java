package com.ty.Hospital_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital_boot.dto.Encounter;
import com.ty.Hospital_boot.service.EncounterService;
import com.ty.Hospital_boot.util.ResponseStructure;

@RestController
@RequestMapping("encounter")
public class EncounterController {
	
	@Autowired
  private EncounterService encounterService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter) {
		return encounterService.saveEncounter(encounter);
		
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,@RequestParam int id) {
		return encounterService.updateEncounter(encounter, id);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@PathVariable int id) {
		return encounterService.getEncounterById(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounterById(@RequestParam int id) {
		return deleteEncounterById(id);
	}
	

}
