package com.ty.Hospital_boot.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.Hospital_boot.dto.Hospital;
import com.ty.Hospital_boot.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	HospitalRepository hospitalrepository;
	
	public Hospital saveHospital(Hospital hospital)
	{
		return hospitalrepository.save(hospital);
	}
	public Hospital updateHospital(Hospital hospital)
	{
		return hospitalrepository.save(hospital);
	}
	
	public Hospital getHospitalById(int id)
	{
		Optional<Hospital> optional=hospitalrepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}

	public String deleteHospitalById(int id)
	{
		hospitalrepository.deleteById(id);
		return "deleted";
	}
}
