package com.hams.spring.HAMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hams.spring.HAMS.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
}
