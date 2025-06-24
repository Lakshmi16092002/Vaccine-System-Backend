package org.vaccine.vaccinationmanagementsystem.appointment;

import jakarta.persistence.*;

import org.vaccine.vaccinationmanagementsystem.user.User;

import org.vaccine.vaccinationmanagementsystem.vaccinationcenter.VaccinationCenter;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.LocalTime;

@Entity

@Table(name = "appointments")

public class Appointment {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "user_id", nullable = false)

    private User user;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "vaccination_center_id", nullable = false)

    private VaccinationCenter vaccinationCenter;

    @Column(nullable = false)

    private LocalDate appointmentDate;

    @Column(nullable = false)

    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)

    @Column(nullable = false)

    private AppointmentStatus status = AppointmentStatus.SCHEDULED;

    private String vaccineType;

    @Column(nullable = false, updatable = false)

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime vaccinatedAt;

    private String certificateNumber;

    // Constructors

    public Appointment() {}

    public Appointment(User user, VaccinationCenter vaccinationCenter, LocalDate appointmentDate, LocalTime appointmentTime, String vaccineType) {

        this.user = user;

        this.vaccinationCenter = vaccinationCenter;

        this.appointmentDate = appointmentDate;

        this.appointmentTime = appointmentTime;

        this.vaccineType = vaccineType;

        this.status = AppointmentStatus.SCHEDULED;

        this.createdAt = LocalDateTime.now();

    }

    @PreUpdate

    protected void onUpdate() {

        // This ensures updatedAt functionality if needed later

    }

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public VaccinationCenter getVaccinationCenter() { return vaccinationCenter; }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) { this.vaccinationCenter = vaccinationCenter; }

    public LocalDate getAppointmentDate() { return appointmentDate; }

    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }

    public LocalTime getAppointmentTime() { return appointmentTime; }

    public void setAppointmentTime(LocalTime appointmentTime) { this.appointmentTime = appointmentTime; }

    public AppointmentStatus getStatus() { return status; }

    public void setStatus(AppointmentStatus status) { this.status = status; }

    public String getVaccineType() { return vaccineType; }

    public void setVaccineType(String vaccineType) { this.vaccineType = vaccineType; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getVaccinatedAt() { return vaccinatedAt; }

    public void setVaccinatedAt(LocalDateTime vaccinatedAt) { this.vaccinatedAt = vaccinatedAt; }

    public String getCertificateNumber() { return certificateNumber; }

    public void setCertificateNumber(String certificateNumber) { this.certificateNumber = certificateNumber; }

}

