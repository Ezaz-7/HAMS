package com.app.Hospital.Management.System.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Hospital.Management.System.entities.DoctorSchedule;
import com.app.Hospital.Management.System.entities.ScheduledId;
@Repository
public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, ScheduledId> {

	
	List<DoctorSchedule> findByDoctorId(Long id);
	

}
