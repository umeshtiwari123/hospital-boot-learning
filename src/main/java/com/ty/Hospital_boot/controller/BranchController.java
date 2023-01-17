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

import com.ty.Hospital_boot.dto.Branch;
import com.ty.Hospital_boot.service.BranchService;
import com.ty.Hospital_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("branch")
public class BranchController {

	@Autowired
	BranchService branchservice;
	
	@ApiOperation(value = "Save Branch", notes = "Used to Save Branch")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch)
	{
		return branchservice.saveBranch(branch);
	}
	
	@ApiOperation(value = "Fetch the Branch", notes = "Used to Get the Branch Details")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int id)
	{
		return branchservice.getBranchById(id);
	}
	
	@ApiOperation(value = "Update the Branch", notes = "Used to Update the Branch Details")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestBody Branch branch,@RequestParam int id)
	{
		return branchservice.updateBranch(branch, id);
	}
	
	@ApiOperation(value = "Delete the Branch", notes = "Used to Delete the Branch Details")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error") })
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<String>> deleteBranchById(@RequestParam int id) 
	{
		return branchservice.deleteBranchById(id);
	}
}
