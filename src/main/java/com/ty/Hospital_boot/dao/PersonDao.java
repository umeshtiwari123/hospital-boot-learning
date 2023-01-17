package com.ty.Hospital_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital_boot.dto.Person;
import com.ty.Hospital_boot.repository.PersonRepo;

@Repository
public class PersonDao {
	@Autowired
	PersonRepo personRepo;
	
	public Person savePerson(Person person) {
		return personRepo.save(person);
		
	}
	
	public Person updatePerson(Person person,int id) {
		return personRepo.save(person);
		
	}
	
	public Person getPersonById(int id) {
		Optional<Person> optional = personRepo.findById(id);

		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
		
	}
	
	public String deletePerson(int id) {
		personRepo.deleteById(id);
		return "deleted";
		
	}
	
	

}


