package com.hams.spring.HAMS.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue
	private int patientId;
	private String name;
	private String dateOfBirth;
	private String medicalHistory;
	private String contactDetails;
	
	
}
