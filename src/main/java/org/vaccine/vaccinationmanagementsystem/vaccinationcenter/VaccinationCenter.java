package org.vaccine.vaccinationmanagementsystem.vaccinationcenter;
import jakarta.persistence.*;
import org.vaccine.vaccinationmanagementsystem.appointment.Appointment;
import org.vaccine.vaccinationmanagementsystem.vaccinestock.VaccineStock;


import java.time.LocalTime;

import java.util.List;


@Entity

@Table(name = "vaccination_centers")

public class VaccinationCenter {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @Column(nullable = false)

    private String name;


    @Column(nullable = false)

    private String address;


    @Column(nullable = false)

    private String city;


    @Column(nullable = false)

    private String state;


    @Column(nullable = false)

    private String pincode;


    private String phoneNumber;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private Integer dailyCapacity = 100;


    @Enumerated(EnumType.STRING)

    private CenterStatus status = CenterStatus.ACTIVE;


    @OneToMany(mappedBy = "vaccinationCenter", cascade = CascadeType.ALL)

    private List<VaccineStock> vaccineStocks;


    @OneToMany(mappedBy = "vaccinationCenter", cascade = CascadeType.ALL)

    private List<Appointment> appointments;


// Constructors

    public VaccinationCenter() {}


// Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }


    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }


    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }


    public String getState() { return state; }

    public void setState(String state) { this.state = state; }


    public String getPincode() { return pincode; }

    public void setPincode(String pincode) { this.pincode = pincode; }


    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }


    public LocalTime getOpeningTime() { return openingTime; }

    public void setOpeningTime(LocalTime openingTime) { this.openingTime = openingTime; }


    public LocalTime getClosingTime() { return closingTime; }

    public void setClosingTime(LocalTime closingTime) { this.closingTime = closingTime; }


    public Integer getDailyCapacity() { return dailyCapacity; }

    public void setDailyCapacity(Integer dailyCapacity) { this.dailyCapacity = dailyCapacity; }


    public CenterStatus getStatus() { return status; }

    public void setStatus(CenterStatus status) { this.status = status; }


    public List<VaccineStock> getVaccineStocks() { return vaccineStocks; }

    public void setVaccineStocks(List<VaccineStock> vaccineStocks) { this.vaccineStocks = vaccineStocks; }


    public List<Appointment> getAppointments() { return appointments; }

    public void setAppointments(List<Appointment> appointments) { this.appointments = appointments; }

}


enum CenterStatus {

    ACTIVE, INACTIVE, DISABLED

}