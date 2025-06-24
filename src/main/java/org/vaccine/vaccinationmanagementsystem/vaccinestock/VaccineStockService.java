package org.vaccine.vaccinationmanagementsystem.vaccinestock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaccine.vaccinationmanagementsystem.vaccinationcenter.VaccinationCenter;
import org.vaccine.vaccinationmanagementsystem.vaccinationcenter.VaccinationCenterService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineStockService {

    @Autowired
    private VaccineStockRepository vaccineStockRepository;

    @Autowired
    private VaccinationCenterService vaccinationCenterService;

    public VaccineStock addOrUpdateStock(Long centerId, String vaccineType, Integer quantity) {
        VaccinationCenter center = vaccinationCenterService.findById(centerId);

        Optional<VaccineStock> existingStock = vaccineStockRepository
                .findByVaccinationCenterIdAndVaccineType(centerId, vaccineType);

        VaccineStock stock;
        if (existingStock.isPresent()) {
            stock = existingStock.get();
            stock.setAvailableStock(quantity);
        } else {
            stock = new VaccineStock(center, vaccineType, quantity);
        }

        stock.setLastUpdated(LocalDateTime.now());
        return vaccineStockRepository.save(stock);
    }

    public List<VaccineStock> getCenterStocks(Long centerId) {
        return vaccineStockRepository.findByVaccinationCenterId(centerId);
    }

    public List<VaccineStock> getAllStocks() {
        return vaccineStockRepository.findAll();
    }

    public void deleteStock(Long stockId) {
        vaccineStockRepository.deleteById(stockId);
    }
}

