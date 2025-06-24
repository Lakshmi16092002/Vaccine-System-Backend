package org.vaccine.vaccinationmanagementsystem.vaccinestock;

import jakarta.persistence.*;
import org.vaccine.vaccinationmanagementsystem.vaccinationcenter.VaccinationCenter;


import java.time.LocalDateTime;


@Entity

@Table(name = "vaccine_stocks")

public class VaccineStock {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @ManyToOne

    @JoinColumn(name = "vaccination_center_id", nullable = false)

    private VaccinationCenter vaccinationCenter;


    @Column(nullable = false)

    private String vaccineType;


    @Column(nullable = false)

    private Integer availableStock = 0;


    private LocalDateTime lastUpdated = LocalDateTime.now();


// Constructors

    public VaccineStock() {}


    public VaccineStock(VaccinationCenter vaccinationCenter, String vaccineType, Integer availableStock) {

        this.vaccinationCenter = vaccinationCenter;

        this.vaccineType = vaccineType;

        this.availableStock = availableStock;

    }


// Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }


    public VaccinationCenter getVaccinationCenter() { return vaccinationCenter; }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) { this.vaccinationCenter = vaccinationCenter; }


    public String getVaccineType() { return vaccineType; }

    public void setVaccineType(String vaccineType) { this.vaccineType = vaccineType; }


    public Integer getAvailableStock() { return availableStock; }

    public void setAvailableStock(Integer availableStock) { this.availableStock = availableStock; }


    public LocalDateTime getLastUpdated() { return lastUpdated; }

    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }

}