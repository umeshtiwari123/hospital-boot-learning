package com.ty.Hospital_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.ty.Hospital_boot.dto.Person;
import com.ty.Hospital_boot.service.PersonService;
import com.ty.Hospital_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@ApiOperation(value="Save Person" , notes="It is used to save person detail")
	@ApiResponses(value= {@ApiResponse(code=201, message="Created"),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=404, message="Not Found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces= {
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	
	@ApiOperation(value="Update Person" , notes="It is used to update the person detail")
	@ApiResponses(value= {@ApiResponse(code=201, message="Created"),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=404, message="Not Found")})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces= {
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Person>>  updatePerson(@RequestBody Person person,@RequestParam  int id) {
		return personService.updatePerson(person , id);
		
	}
	@ApiOperation(value="Get the Person" , notes="It is used to get the person detail")
	@ApiResponses(value= {@ApiResponse(code=201, message="Created"),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=404, message="Not Found")})
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);
		
	}
	
	@ApiOperation(value="Delete Person" , notes="It is used to Delete the person detail")
	@ApiResponses(value= {@ApiResponse(code=201, message="Created"),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=404, message="Not Found")})
	@DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces= {
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<String>> deletePersonById(@RequestParam int id) {
		return personService.deletePersonById(id);
	}

}
