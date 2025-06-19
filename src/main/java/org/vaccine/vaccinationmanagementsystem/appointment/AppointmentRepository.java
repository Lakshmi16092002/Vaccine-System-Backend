package org.vaccine.vaccinationmanagementsystem.appointment;

import com.vaccination.entity.Appointment;

import com.vaccination.entity.AppointmentStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.time.LocalDate;

import java.util.List;


@Repository

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByUserId(Long userId);

    List<Appointment> findByVaccinationCenterId(Long centerId);


    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.vaccinationCenter.id = :centerId AND a.appointmentDate = :date AND a.status = :status")

    Long countByVaccinationCenterIdAndAppointmentDateAndStatus(Long centerId, LocalDate date, AppointmentStatus status);


    List<Appointment> findByStatus(AppointmentStatus status);

}