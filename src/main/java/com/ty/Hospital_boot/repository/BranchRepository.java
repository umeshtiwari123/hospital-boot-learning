package com.ty.Hospital_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Hospital_boot.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
