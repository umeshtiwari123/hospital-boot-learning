package com.ty.Hospital_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital_boot.dao.PersonDao;
import com.ty.Hospital_boot.dto.Person;
import com.ty.Hospital_boot.exception.NoSuchIdFoundException;
import com.ty.Hospital_boot.exception.NoSuchIdPresentForUpdateException;
import com.ty.Hospital_boot.util.ResponseStructure;

@Service
public class PersonService {
	
	
	@Autowired
	private PersonDao personDao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(
				responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(personDao.savePerson(person));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person person, int id) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(
				responseStructure, HttpStatus.CREATED);
		Person person2 = personDao.getPersonById(id);

		if (person2 != null) {
			person.setId(id);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(personDao.updatePerson(person, id));
			return responseEntity;
		} else 
		
			throw new NoSuchIdPresentForUpdateException("No Person Id is found for Updation");

	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id) {

		Person person = personDao.getPersonById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(
				responseStructure, HttpStatus.OK);
		if (person != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("returning person data");
			responseStructure.setData(personDao.getPersonById(id));
			return responseEntity;
		}
			else throw new NoSuchIdFoundException("Person Id Not Found");
	}

	public ResponseEntity<ResponseStructure<String>> deletePersonById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(personDao.deletePerson(id));
			return responseEntity;
		}

}