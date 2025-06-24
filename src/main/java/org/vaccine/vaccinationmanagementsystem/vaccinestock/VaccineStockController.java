package org.vaccine.vaccinationmanagementsystem.vaccinestock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vaccine-stocks")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccineStockController {

    @Autowired
    private VaccineStockService vaccineStockService;

    // UPDATED METHOD WITH DEBUG LOGGING AND BETTER ERROR HANDLING
    @PostMapping("/center/{centerId}")
    public ResponseEntity<?> addOrUpdateStock(@PathVariable Long centerId,
                                              @RequestParam String vaccineType,
                                              @RequestParam Integer quantity) {
        try {
            // Debug logging
            System.out.println("Received request - CenterId: " + centerId + ", VaccineType: " + vaccineType + ", Quantity: " + quantity);

            VaccineStock stock = vaccineStockService.addOrUpdateStock(centerId, vaccineType, quantity);

            // Return a simple response to avoid JSON issues
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Stock updated successfully");
            response.put("stockId", stock.getId());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.err.println("Error updating stock: " + e.getMessage());
            e.printStackTrace();

            Map<String, String> error = new HashMap<>();
            error.put("success", "false");
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/center/{centerId}")
    public ResponseEntity<List<VaccineStock>> getCenterStocks(@PathVariable Long centerId) {
        return ResponseEntity.ok(vaccineStockService.getCenterStocks(centerId));
    }

    @GetMapping
    public ResponseEntity<List<VaccineStock>> getAllStocks() {
        return ResponseEntity.ok(vaccineStockService.getAllStocks());
    }

    @DeleteMapping("/{stockId}")
    public ResponseEntity<?> deleteStock(@PathVariable Long stockId) {
        try {
            vaccineStockService.deleteStock(stockId);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Stock deleted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
