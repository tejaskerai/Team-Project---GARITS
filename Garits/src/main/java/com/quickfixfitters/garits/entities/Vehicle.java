package com.quickfixfitters.garits.entities;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @Column(name = "RegNo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regNo;

    @Column(name = "Make")
    private String make;

    @Column(name = "Model")
    private String model;

    @Column(name = "EngSerial")
    private String engSerial;

    @Column(name = "ChassisNo")
    private String chassisNo;

    @Column(name = "Color")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(mappedBy = "vehicle")
    private List<JobSheet> jobSheets;


    public Vehicle(String make, String model, String engSerial, String chassisNo, String color) {
        this.make = make;
        this.model = model;
        this.engSerial = engSerial;
        this.chassisNo = chassisNo;
        this.color = color;
    }

    public Vehicle() {
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngSerial() {
        return engSerial;
    }

    public void setEngSerial(String engSerial) {
        this.engSerial = engSerial;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<JobSheet> getJobSheets() {
        return jobSheets;
    }

    public void setJobSheets(List<JobSheet> jobSheets) {
        this.jobSheets = jobSheets;
    }
    
}
