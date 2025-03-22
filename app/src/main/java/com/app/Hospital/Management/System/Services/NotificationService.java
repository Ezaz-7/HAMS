package com.app.Hospital.Management.System.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Hospital.Management.System.entities.Appointment;
import com.app.Hospital.Management.System.entities.Notification;
import com.app.Hospital.Management.System.repositories.AppointmentRepository;
import com.app.Hospital.Management.System.repositories.NotificationRepository;

@Service
public class NotificationService {
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Notification saveNotification(Notification n) {
		return notificationRepository.save(n);
	}
	
	public List<Notification> getAllNotifications(){
		return notificationRepository.findAll();
	}
	public Optional<Notification> getNotificationById(Long id){
		return notificationRepository.findById(id);
	}
	
//	public List<Notification> getNotificationsByPatientId(Long patientId) {
//        return notificationRepository.findByPatientId(patientId);
//    }
	
	
//	
//	public Notification createScheduledNotification(Long appointmentId) {
//        return createNotification(appointmentId, "Scheduled");
//    }
//
//    public Notification createCancelledNotification(Long appointmentId) {
//        return createNotification(appointmentId, "Cancelled");
//    }
//
//    public Notification createCompletedNotification(Long appointmentId) {
//        return createNotification(appointmentId, "Completed");
//    }

//    private Notification createNotification(Long appointmentId, String status) {
//        // Fetch appointment details
//        Appointment appointment = appointmentRepository.findById(appointmentId)
//        		.orElseThrow(() -> new RuntimeException("Appointment not found."));
//
//        if (!appointment.getStatus().equalsIgnoreCase(status)) {
//            throw new IllegalStateException("Invalid status transition.");
//        }
//
//        // Create notification
//        Notification notification = new Notification();
//        notification.setPatientId(appointment.getPatientId());
//        notification.setMessage("Your appointment has been " + status + ".");
//        notification.setTimestamp(LocalDateTime.now());
//
//        // Save notification in the database
//        return notificationRepository.save(notification);
//    }
}
