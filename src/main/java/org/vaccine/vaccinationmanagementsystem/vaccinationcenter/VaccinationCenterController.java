package org.vaccine.vaccinationmanagementsystem.vaccinationcenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/centers")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccinationCenterController {

    @Autowired
    private VaccinationCenterService vaccinationCenterService;

    @PostMapping
    public ResponseEntity<?> createCenter(@RequestBody VaccinationCenter center) {
        try {
            VaccinationCenter savedCenter = vaccinationCenterService.createCenter(center);
            return ResponseEntity.ok(savedCenter);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<VaccinationCenter>> getAllCenters() {
        return ResponseEntity.ok(vaccinationCenterService.getAllCenters());
    }

    @GetMapping("/active")
    public ResponseEntity<List<VaccinationCenter>> getActiveCenters() {
        return ResponseEntity.ok(vaccinationCenterService.getActiveCenters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCenterById(@PathVariable Long id) {
        try {
            VaccinationCenter center = vaccinationCenterService.findById(id);
            return ResponseEntity.ok(center);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCenter(@PathVariable Long id, @RequestBody VaccinationCenter center) {
        try {
            VaccinationCenter updatedCenter = vaccinationCenterService.updateCenter(id, center);
            return ResponseEntity.ok(updatedCenter);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCenter(@PathVariable Long id) {
        try {
            vaccinationCenterService.deleteCenter(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Center deleted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PutMapping("/{id}/disable")
    public ResponseEntity<?> disableCenter(@PathVariable Long id) {
        try {
            VaccinationCenter center = vaccinationCenterService.disableCenter(id);
            return ResponseEntity.ok(center);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PutMapping("/{id}/enable")
    public ResponseEntity<?> enableCenter(@PathVariable Long id) {
        try {
            VaccinationCenter center = vaccinationCenterService.enableCenter(id);
            return ResponseEntity.ok(center);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/search/city/{city}")
    public ResponseEntity<List<VaccinationCenter>> searchByCity(@PathVariable String city) {
        return ResponseEntity.ok(vaccinationCenterService.searchCentersByCity(city));
    }

    @GetMapping("/search/pincode/{pincode}")
    public ResponseEntity<List<VaccinationCenter>> searchByPincode(@PathVariable String pincode) {
        return ResponseEntity.ok(vaccinationCenterService.searchCentersByPincode(pincode));
    }
}

