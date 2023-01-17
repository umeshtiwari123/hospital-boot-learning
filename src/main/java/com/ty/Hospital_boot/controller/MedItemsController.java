package com.ty.Hospital_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital_boot.dto.MedItems;
import com.ty.Hospital_boot.service.MedItemsService;
import com.ty.Hospital_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("meditems")
public class MedItemsController {

	@Autowired
	MedItemsService service;

	@ApiOperation(value = "Update MedItems", notes = "Used to update Meditems")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<MedItems>> updateMeditems(@RequestBody MedItems medItems,
			@RequestParam int id) {
		return service.serviceupdateMedItems(medItems, id);
	}

	@ApiOperation(value = "Find Meditems", notes = "Used to find Meditems")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<MedItems>> findMedorder(@RequestParam int id) {
		return service.servicefindbyid(id);
	}

}
