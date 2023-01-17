package com.ty.Hospital_boot.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.Hospital_boot.dto.Branch;
import com.ty.Hospital_boot.repository.BranchRepository;

@Repository
public class BranchDao {

	@Autowired
	BranchRepository branchrepository;
	
	public Branch saveBranch(Branch branch)
	{
		return branchrepository.save(branch);
	}
	public Branch updateBranch(Branch branch)
	{
		return branchrepository.save(branch);
	}
	
	public Branch getBranchById(int id)
	{
		Optional<Branch> optional=branchrepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}

	public String deleteBranchById(int id)
	{
		branchrepository.deleteById(id);
		return "deleted";
	}
}
