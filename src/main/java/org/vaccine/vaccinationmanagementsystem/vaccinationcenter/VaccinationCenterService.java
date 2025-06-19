package org.vaccine.vaccinationmanagementsystem.vaccinationcenter;

import com.vaccination.entity.CenterStatus;
import com.vaccination.entity.VaccinationCenter;
import com.vaccination.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationCenterService {

    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    public VaccinationCenter createCenter(VaccinationCenter center) {
        center.setStatus(CenterStatus.ACTIVE);
        return vaccinationCenterRepository.save(center);
    }

    public VaccinationCenter updateCenter(Long id, VaccinationCenter centerDetails) {
        VaccinationCenter center = vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Center not found"));

        center.setName(centerDetails.getName());
        center.setAddress(centerDetails.getAddress());
        center.setCity(centerDetails.getCity());
        center.setState(centerDetails.getState());
        center.setPincode(centerDetails.getPincode());
        center.setPhoneNumber(centerDetails.getPhoneNumber());
        center.setOpeningTime(centerDetails.getOpeningTime());
        center.setClosingTime(centerDetails.getClosingTime());
        center.setDailyCapacity(centerDetails.getDailyCapacity());

        return vaccinationCenterRepository.save(center);
    }

    public void deleteCenter(Long id) {
        VaccinationCenter center = vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Center not found"));
        vaccinationCenterRepository.delete(center);
    }

    public VaccinationCenter disableCenter(Long id) {
        VaccinationCenter center = vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Center not found"));
        center.setStatus(CenterStatus.DISABLED);
        return vaccinationCenterRepository.save(center);
    }

    public VaccinationCenter enableCenter(Long id) {
        VaccinationCenter center = vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Center not found"));
        center.setStatus(CenterStatus.ACTIVE);
        return vaccinationCenterRepository.save(center);
    }

    public List<VaccinationCenter> getAllCenters() {
        return vaccinationCenterRepository.findAll();
    }

    public List<VaccinationCenter> getActiveCenters() {
        return vaccinationCenterRepository.findByStatus(CenterStatus.ACTIVE);
    }

    public List<VaccinationCenter> searchCentersByCity(String city) {
        return vaccinationCenterRepository.findByCityAndStatus(city, CenterStatus.ACTIVE);
    }

    public List<VaccinationCenter> searchCentersByPincode(String pincode) {
        return vaccinationCenterRepository.findByPincodeAndStatus(pincode, CenterStatus.ACTIVE);
    }

    public VaccinationCenter findById(Long id) {
        return vaccinationCenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Center not found"));
    }
}

