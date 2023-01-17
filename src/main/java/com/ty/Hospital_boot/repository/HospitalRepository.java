package com.ty.Hospital_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Hospital_boot.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
