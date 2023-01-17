package com.ty.Hospital_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.Hospital_boot.dao.BranchDao;
import com.ty.Hospital_boot.dto.Branch;
import com.ty.Hospital_boot.exception.NoSuchIdFoundException;
import com.ty.Hospital_boot.exception.NoSuchIdPresentForUpdateException;
import com.ty.Hospital_boot.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchdao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(branchdao.saveBranch(branch));
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		Branch branch2=branchdao.getBranchById(id);
		if(branch2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(branchdao.getBranchById(id));
		return responseEntity;
		}
		else throw new NoSuchIdFoundException("Branch Id Not Found");
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteBranchById(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);

		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(branchdao.deleteBranchById(id));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch,int id)
	{
		Branch branch2=branchdao.getBranchById(id);
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);

		if(branch2 !=null)
			{
			branch.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(branchdao.updateBranch(branch));
			return responseEntity;
			
			}

		else	
		throw new NoSuchIdPresentForUpdateException("No Branch Id is found for Updation");
	}
}
