package org.vaccine.vaccinationmanagementsystem.appointment;

import java.time.LocalDate;

import java.time.LocalTime;


public class AppointmentDTO {

    private Long userId;

    private Long vaccinationCenterId;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private String vaccineType;


// Constructors

    public AppointmentDTO() {}


// Getters and Setters

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }


    public Long getVaccinationCenterId() { return vaccinationCenterId; }

    public void setVaccinationCenterId(Long vaccinationCenterId) { this.vaccinationCenterId = vaccinationCenterId; }


    public LocalDate getAppointmentDate() { return appointmentDate; }

    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }


    public LocalTime getAppointmentTime() { return appointmentTime; }

    public void setAppointmentTime(LocalTime appointmentTime) { this.appointmentTime = appointmentTime; }


    public String getVaccineType() { return vaccineType; }

    public void setVaccineType(String vaccineType) { this.vaccineType = vaccineType; }

}

