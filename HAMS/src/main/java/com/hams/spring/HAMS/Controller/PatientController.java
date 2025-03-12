package com.hams.spring.HAMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hams.spring.HAMS.Entity.Patient;
import com.hams.spring.HAMS.Service.PatientService;

@RestController
public class PatientController {
	@Autowired
	public PatientService patientService;
	
	@GetMapping("/patients")
	public List<Patient> getPatients(Patient p){
		return patientService.getAllPatients();
	}
	
	@PostMapping("/addpatients")
	public String add(@RequestBody Patient p) {
		return patientService.addPatient(p);
	}
	
	
	
}
