package com.quickfixfitters.garits.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "JobSheet")
public class JobSheet {

    @Id
    @Column(name = "JobNo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobNo;

    @Column(name = "DateBookedIn")
    private Date dateBookedIn;

    @Column(name = "DescriptionOfWork")
    private String descriptionOfWork;
    
    @Column(name = "DescriptionAfterWork")
    private String descriptionAfterWork;

    @Column(name = "EstimatedTime")
    private String estimatedTime;

    @Column(name = "DateCompleted")
    private Date dateCompleted;

    @Column(name = "RegNo")
    private String regNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VehicleId", insertable = false, updatable = false)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MechanicId", insertable = false, updatable = false)
    private Mechanic mechanic;


    // using this relation
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobSheet> jobSheet;

    // Using this relation 
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Part> part;

    
    @OneToMany(mappedBy = "jobSheet")
    private List<Invoice> invoices;

//    @OneToMany(mappedBy = "jobSheet")
//    private List<Part> parts;

    public JobSheet(Date dateBookedIn, String descriptionOfWork, String descriptionAfterWork, String estimatedTime, Date dateCompleted, String regNo) {
        this.dateBookedIn = dateBookedIn;
        this.descriptionOfWork = descriptionOfWork;
        this.descriptionAfterWork = descriptionAfterWork;
        this.estimatedTime = estimatedTime;
        this.dateCompleted = dateCompleted;
        this.regNo = regNo;
    }

    

    public JobSheet(Date dateBookedIn, String descriptionOfWork, String estimatedTime, String regNo) {
        this.dateBookedIn = dateBookedIn;
        this.descriptionOfWork = descriptionOfWork;
        this.estimatedTime = estimatedTime;
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

    public String getDescriptionOfWork() {
        return descriptionOfWork;
    }

    public void setDescriptionOfWork(String descriptionOfWork) {
        this.descriptionOfWork = descriptionOfWork;
    }

    public String getDescriptionAfterWork() {
        return descriptionAfterWork;
    }

    public void setDescriptionAfterWork(String descriptionAfterWork) {
        this.descriptionAfterWork = descriptionAfterWork;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<JobSheet> getJobSheet() {
        return jobSheet;
    }

    public void setJobSheet(List<JobSheet> jobSheet) {
        this.jobSheet = jobSheet;
    }

    public List<Part> getPart() {
        return part;
    }

    public void setPart(List<Part> part) {
        this.part = part;
    }

    
    
}
