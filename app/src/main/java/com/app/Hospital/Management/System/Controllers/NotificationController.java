package com.app.Hospital.Management.System.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.app.Hospital.Management.System.Services.NotificationService;
import com.app.Hospital.Management.System.entities.Notification;
import com.app.Hospital.Management.System.exceptions.BadRequestException;
import com.app.Hospital.Management.System.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospital/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping("/save")
    public ResponseEntity<Notification> saveNotification(@RequestBody Notification n) {
        try {
            Notification no = service.saveNotification(n);
            return ResponseEntity.ok(no);
        } catch (Exception e) {
            throw new BadRequestException("Failed to save notification: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> list = service.getAllNotifications();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No notifications found");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Optional<Notification> optional = service.getNotificationById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            throw new ResourceNotFoundException("Notification not found with id: " + id);
        }
    }
}