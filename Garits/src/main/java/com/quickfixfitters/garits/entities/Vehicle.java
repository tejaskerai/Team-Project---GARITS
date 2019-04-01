package com.quickfixfitters.garits.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @Column(name = "RegNo", unique = true, nullable = false)
    private String regNo;

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

    @Column(name = "RenewalTestDate")
    private Date renewalTestDate;
    
    @Column(name = "RenewalReminderDate")
    private Date renewalReminderDate;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;
    
    // Using this one
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobSheet> jobSheet;


    @OneToMany(mappedBy = "vehicle")
    private List<JobSheet> jobSheets;
    
    @OneToMany(mappedBy = "motVehicle")
    private List<MOTReminder> motReminders;

    public Vehicle(String regNo, String chassisNo, String colour, String engSerial, 
                   String make, String model, Date renewalDate, Date reminderDate) {
        this.regNo = regNo;
        this.make = make;
        this.model = model;
        this.engSerial = engSerial;
        this.chassisNo = chassisNo;
        this.color = colour;
        this.renewalTestDate = renewalDate;
        this.renewalReminderDate = reminderDate;
        
        
    }

    public Vehicle() {
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
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

    public List<MOTReminder> getMotReminders() {
        return motReminders;
    }

    public void setMotReminders(List<MOTReminder> motReminders) {
        this.motReminders = motReminders;
    }

    public Date getRenewalTestDate() {
        return renewalTestDate;
    }

    public void setRenewalTestDate(Date renewalTestDate) {
        this.renewalTestDate = renewalTestDate;
    }

    public List<JobSheet> getJobSheet() {
        return jobSheet;
    }

    public void setJobSheet(List<JobSheet> jobSheet) {
        this.jobSheet = jobSheet;
    }

    public Date getRenewalReminderDate() {
        return renewalReminderDate;
    }

    public void setRenewalReminderDate(Date renewalReminderDate) {
        this.renewalReminderDate = renewalReminderDate;
    }
    
}
