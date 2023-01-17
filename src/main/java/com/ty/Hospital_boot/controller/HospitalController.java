package com.ty.Hospital_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital_boot.dto.Hospital;
import com.ty.Hospital_boot.service.HospitalService;
import com.ty.Hospital_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("hospital")
public class HospitalController {

	@Autowired
	HospitalService hospitalservice;
	
	@ApiOperation(value = "Save The Hospital", notes = "Used to Save the Hospital Details")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital)
	{
		return hospitalservice.saveHospital(hospital);
	}
	
	@ApiOperation(value = "Get The Hospital", notes = "Used to Get the Hospital Details")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id)
	{
		return hospitalservice.getHospitalById(id);
	}
	
	@ApiOperation(value = "Update The Hospital", notes = "Used to Update the Hospital Details")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(@RequestBody Hospital hospital,@RequestParam int id)
	{
		return hospitalservice.updateHospital(hospital, id);
	}
	
	@ApiOperation(value = "Delete The Hospital", notes = "Used to Delete the Hospital Details")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(@RequestParam int id) 
	{
		return hospitalservice.deleteHospitalById(id);
	}
}
