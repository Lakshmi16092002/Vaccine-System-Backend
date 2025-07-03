package org.vaccine.vaccinationmanagementsystem.appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    @Autowired
    private org.vaccine.vaccinationmanagementsystem.appointment.AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> bookAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        try {
            Appointment appointment = appointmentService.bookAppointment(appointmentDTO);
            System.out.println(appointmentDTO);
            return ResponseEntity.ok(appointmentDTO);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Appointment>> getUserAppointments(@PathVariable Long userId) {
        return ResponseEntity.ok(appointmentService.getUserAppointments(userId));
    }

    @GetMapping("/center/{centerId}")
    public ResponseEntity<List<Appointment>> getCenterAppointments(@PathVariable Long centerId) {
        return ResponseEntity.ok(appointmentService.getCenterAppointments(centerId));
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointmentById(@PathVariable Long id) {
        try {
            org.vaccine.vaccinationmanagementsystem.appointment.Appointment appointment = appointmentService.findById(id);
            return ResponseEntity.ok(appointment);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<?> markAsCompleted(@PathVariable Long id) {
        try {
            org.vaccine.vaccinationmanagementsystem.appointment.Appointment appointment = appointmentService.markAsCompleted(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Appointment marked as completed");
            response.put("certificateNumber", appointment.getCertificateNumber());
            response.put("appointment", appointment);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}

