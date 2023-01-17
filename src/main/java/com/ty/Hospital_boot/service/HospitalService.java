package com.ty.Hospital_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.Hospital_boot.dao.HospitalDao;
import com.ty.Hospital_boot.dto.Hospital;
import com.ty.Hospital_boot.exception.NoSuchIdFoundException;
import com.ty.Hospital_boot.exception.NoSuchIdPresentForUpdateException;
import com.ty.Hospital_boot.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	HospitalDao hospitaldao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital)
	{
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(hospitaldao.saveHospital(hospital));
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id)
	{
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		Hospital hospital2=hospitaldao.getHospitalById(id);
		if(hospital2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(hospitaldao.getHospitalById(id));
		return responseEntity;
		}
		else throw new NoSuchIdFoundException("Hospital Id Not Found");
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);

		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(hospitaldao.deleteHospitalById(id));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital,int id)
	{
		Hospital hospital2=hospitaldao.getHospitalById(id);
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);

		if(hospital2 !=null)
			{
			hospital.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(hospitaldao.updateHospital(hospital));
			return responseEntity;
			
			}

		else	
		throw new NoSuchIdPresentForUpdateException("No Hospital Id is found for Updation");
	}
}
