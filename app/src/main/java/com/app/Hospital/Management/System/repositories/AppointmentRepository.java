package com.app.Hospital.Management.System.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Hospital.Management.System.entities.Appointment;
import com.app.Hospital.Management.System.entities.AppointmentStatus;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByStatus(AppointmentStatus status);
	
	@Modifying
	@Query("DELETE FROM Appointment a WHERE a.patient.patientId = :patientId")
	void deleteByPatientId(@Param("patientId") Long patientId);

}
