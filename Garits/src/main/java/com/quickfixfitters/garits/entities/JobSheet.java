package com.quickfixfitters.garits.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "JobSheet")
public class JobSheet {

    @Id
    @Column(name = "JobNo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int jobNo;

    @Column(name = "DateBookedIn")
    private Date dateBookedIn;

    @Column(name = "JobType")
    private String jobType;

    @Column(name = "DescriptionOfWork")
    private String descriptionOfWork;

    @Column(name = "EstimatedTime")
    private int estimatedTime;

    @Column(name = "DateCompleted")
    private Date dateCompleted;

    @Column(name = "Price")
    private float price;

    @Column(name = "CustomerType")
    private String customerType;

    @Column(name = "RegNo")
    private int regNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VehicleId", insertable = false, updatable = false)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MechanicId", insertable = false, updatable = false)
    private Mechanic mechanic;


    @OneToMany(mappedBy = "jobSheet")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "jobSheet")
    private List<Part> parts;

    public JobSheet(Date dateBookedIn, String jobType, String descriptionOfWork, int estimatedTime, Date dateCompleted, float price, String customerType, int regNo) {
        this.dateBookedIn = dateBookedIn;
        this.jobType = jobType;
        this.descriptionOfWork = descriptionOfWork;
        this.estimatedTime = estimatedTime;
        this.dateCompleted = dateCompleted;
        this.price = price;
        this.customerType = customerType;
        this.regNo = regNo;
    }

    public JobSheet() {
    }

    public int getJobNo() {
        return jobNo;
    }

    public void setJobNo(int jobNo) {
        this.jobNo = jobNo;
    }

    public Date getDateBookedIn() {
        return dateBookedIn;
    }

    public void setDateBookedIn(Date dateBookedIn) {
        this.dateBookedIn = dateBookedIn;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getDescriptionOfWork() {
        return descriptionOfWork;
    }

    public void setDescriptionOfWork(String descriptionOfWork) {
        this.descriptionOfWork = descriptionOfWork;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

}
