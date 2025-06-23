package org.vaccine.vaccinationmanagementsystem.vaccinestock;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;

import java.util.Optional;


@Repository

public interface VaccineStockRepository extends JpaRepository<VaccineStock, Long> {

    List<VaccineStock> findByVaccinationCenterId(Long centerId);

    Optional<VaccineStock> findByVaccinationCenterIdAndVaccineType(Long centerId, String vaccineType);

}
