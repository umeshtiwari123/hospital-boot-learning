package com.ty.Hospital_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Hospital_boot.dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer> {

}
