package org.vaccine.vaccinationmanagementsystem.appointment;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.vaccine.vaccinationmanagementsystem.user.User;

import org.vaccine.vaccinationmanagementsystem.user.UserService;

import org.vaccine.vaccinationmanagementsystem.vaccinationcenter.VaccinationCenter;

import org.vaccine.vaccinationmanagementsystem.vaccinationcenter.VaccinationCenterService;

import java.time.LocalDateTime;

import java.util.List;

import java.util.UUID;

@Service

public class AppointmentService {

    @Autowired

    private AppointmentRepository appointmentRepository;

    @Autowired

    private UserService userService;

    @Autowired

    private VaccinationCenterService vaccinationCenterService;

    public Appointment bookAppointment(AppointmentDTO appointmentDTO) {

        User user = userService.findById(appointmentDTO.getUserId());

        VaccinationCenter center = vaccinationCenterService.findById(appointmentDTO.getVaccinationCenterId());
        System.out.println(center);
        // Check capacity

        Long bookedCount = appointmentRepository.countByVaccinationCenterIdAndAppointmentDateAndStatus(

                center.getId(), appointmentDTO.getAppointmentDate(), AppointmentStatus.SCHEDULED);

        if (bookedCount >= center.getDailyCapacity()) {

            throw new RuntimeException("Center capacity full for the selected date");

        }

        Appointment appointment = new Appointment();

        appointment.setUser(user); // Now this will work!

        appointment.setVaccinationCenter(center);

        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());

        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());

        appointment.setVaccineType(appointmentDTO.getVaccineType());

        appointment.setStatus(AppointmentStatus.SCHEDULED);

        return appointmentRepository.save(appointment);

    }

    public List<Appointment> getUserAppointments(Long userId) {

        return appointmentRepository.findByUserId(userId);

    }

    public List<Appointment> getCenterAppointments(Long centerId) {

        return appointmentRepository.findByVaccinationCenterId(centerId);

    }

    public Appointment markAsCompleted(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)

                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(AppointmentStatus.COMPLETED);

        appointment.setVaccinatedAt(LocalDateTime.now());

        appointment.setCertificateNumber(generateCertificateNumber());

        return appointmentRepository.save(appointment);

    }

    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();

    }

    public Appointment findById(Long id) {

        return appointmentRepository.findById(id)

                .orElseThrow(() -> new RuntimeException("Appointment not found"));

    }

    private String generateCertificateNumber() {

        return "CERT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

    }

}

