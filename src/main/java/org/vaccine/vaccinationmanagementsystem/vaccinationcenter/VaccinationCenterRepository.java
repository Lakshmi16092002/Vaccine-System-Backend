package org.vaccine.vaccinationmanagementsystem.vaccinationcenter;

import com.vaccination.entity.VaccinationCenter;

import com.vaccination.entity.CenterStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;


@Repository

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Long> {

    List<VaccinationCenter> findByStatus(CenterStatus status);

    List<VaccinationCenter> findByCityAndStatus(String city, CenterStatus status);

    List<VaccinationCenter> findByPincodeAndStatus(String pincode, CenterStatus status);

}