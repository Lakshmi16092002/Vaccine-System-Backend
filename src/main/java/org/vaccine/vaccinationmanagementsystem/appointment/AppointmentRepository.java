package org.vaccine.vaccinationmanagementsystem.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Fixed to use user.id instead of userId
    List<Appointment> findByUserId(Long userId);
    // Fixed to use vaccinationCenter.id instead of vaccinationCenterId
    List<Appointment> findByVaccinationCenterId(Long centerId);
    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.vaccinationCenter.id = :centerId AND a.appointmentDate = :date AND a.status = :status")
    Long countByVaccinationCenterIdAndAppointmentDateAndStatus(Long centerId, LocalDate date, AppointmentStatus status);
    List<Appointment> findByStatus(AppointmentStatus status);
}