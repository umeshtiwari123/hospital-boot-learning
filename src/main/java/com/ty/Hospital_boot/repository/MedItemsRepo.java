package com.ty.Hospital_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Hospital_boot.dto.MedItems;

public interface MedItemsRepo extends JpaRepository<MedItems, Integer> {

}
