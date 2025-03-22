package com.app.Hospital.Management.System.entities;
 
import java.time.LocalDate;
import java.util.List;
 
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patients")
public class PatientProfile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "patientid", updatable=false)
    private Long patientId;
    
    @NotBlank(message = "Name is mandatory")
    @Column(updatable=false)
    private String name;
    
    @NotNull(message = "Date of birth is mandatory")
    @Past(message = "Date of birth must be in the past")
    @Column(updatable=false)
    private LocalDate dateOfBirth;
    
    @NotBlank(message = "Medical history is mandatory")
    @Column(nullable=false)
    private String medicalHistory;
    
    @NotBlank(message = "Contact details are mandatory")
    @Column(nullable=false)
    private String contactDetails;
    

    
    @OneToMany(mappedBy="patient")
    private List<Appointment> appointmentList;
}