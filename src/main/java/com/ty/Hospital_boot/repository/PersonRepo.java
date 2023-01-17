package com.ty.Hospital_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Hospital_boot.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
