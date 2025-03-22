package com.app.Hospital.Management.System.Controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Hospital.Management.System.Services.AppointmentService;
import com.app.Hospital.Management.System.entities.Appointment;
import com.app.Hospital.Management.System.entities.AppointmentStatus;
import com.app.Hospital.Management.System.exceptions.BadRequestException;
import com.app.Hospital.Management.System.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/hospital/appointments")
@Validated
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    
    
    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@Valid @RequestBody Appointment appointment) {
        String result = appointmentService.bookAppointment(appointment);
        return ResponseEntity.ok(result);
    }

//    @PostMapping("/save")
//    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment) {
//        try {
//            Appointment savedAppointment = appointmentService.bookAppointment(appointment);
//            return ResponseEntity.ok(savedAppointment);
//        } catch (Exception e) {
//            throw new BadRequestException("Failed to create appointment: " + e.getMessage());
//        }
//    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        if (appointments.isEmpty()) {
            throw new ResourceNotFoundException("No appointments found");
        }
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> optional = appointmentService.getAppointmentById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            throw new ResourceNotFoundException("Appointment not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        try {
            appointmentService.deleteAppointment(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Failed to delete appointment: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Appointment> updateAppointmentStatus(@PathVariable Long id, @RequestBody AppointmentStatus newStatus) {
        try {
            Appointment updatedAppointment = appointmentService.updateAppointmentStatus(id, newStatus);
            return ResponseEntity.ok(updatedAppointment);
        } catch (Exception e) {
            throw new BadRequestException("Failed to update appointment status: " + e.getMessage());
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Appointment>> getAppointmentsByStatus(@PathVariable String status) {
        List<Appointment> appointments = appointmentService.getAppointmentsByStatus(status);
        if (appointments.isEmpty()) {
            throw new ResourceNotFoundException("No appointments found with status: " + status);
        }
        return ResponseEntity.ok(appointments);
    }
    
    
//    @PutMapping("/book")
//	public ResponseEntity<String> bookAppointment(@RequestBody AppointmentRequest appointmentRequest) {
//	    LocalDate appointmentDate = LocalDate.parse(appointmentRequest.getDate());
//	    LocalTime appointmentTime = LocalTime.parse(appointmentRequest.getTimeSlot());
//	    String response = appointmentService.bookAppointment(appointmentRequest.getDoctorId(), appointmentDate, appointmentTime);
//	    return ResponseEntity.ok(response);
//	}
}