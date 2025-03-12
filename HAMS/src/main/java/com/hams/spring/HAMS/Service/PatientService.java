package com.hams.spring.HAMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hams.spring.HAMS.Entity.Patient;
import com.hams.spring.HAMS.Repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	public PatientRepository pRepo;

	

	public List<Patient> getAllPatients() {
		return pRepo.findAll();
	}



	public String addPatient(Patient p) {
		pRepo.save(p);
		return "Added";
	}

}
