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

import com.ty.Hospital_boot.dto.MedOrder;
import com.ty.Hospital_boot.service.MedOrderService;
import com.ty.Hospital_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("medorder")
public class MedOrderController {

	@Autowired
	MedOrderService service;

//	@ApiOperation(value = "Save Medorder", notes = "Used to save Medorder")
//	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
//	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ResponseStructure<MedOrder>> saveMedorder(@RequestBody MedOrder medOrder) {
//		return service.servicesaveMedOrder(medOrder);
//	}

	@ApiOperation(value = "Update Medorder", notes = "Used to update Medorder")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedorder(@RequestBody MedOrder medOrder,
			@RequestParam int id) {
		return service.serviceupdateMedOrder(medOrder, id);
	}

	@ApiOperation(value = "Find Medorder", notes = "Used to find Medorder")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<MedOrder>> findMedorder(@RequestParam int id) {
		return service.servicefindbyid(id);
	}

//	@ApiOperation(value = "Delete Medorder", notes = "Used to delete Medorder")
//	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
//	@DeleteMapping
//	public ResponseEntity<ResponseStructure<String>> deleteMedorder(@RequestParam int id) {
//		return service.servicedeletebyid(id);
//	}

}
