package com.ty.Hospital_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Hospital_boot.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter,Integer> {

}
