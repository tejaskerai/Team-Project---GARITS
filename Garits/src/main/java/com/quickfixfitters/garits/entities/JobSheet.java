package com.quickfixfitters.garits.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "JobSheet")
public class JobSheet implements Serializable {

    
    private int jobNo;
    
    private Set<JobPart> jobParts = new HashSet<JobPart>();

    private Date dateBookedIn;

    private String descriptionOfWork;
    
    private String descriptionAfterWork;

    private String estimatedTime;
    
    private String accTime;

    private Date dateCompleted;

    private String regNo;
    
    private String RMechanic;

    private Vehicle vehicle;

    private Mechanic mechanic;
    
    


    // using this relation
    private List<JobSheet> jobSheet;

    // Using this relation 
    private List<Part> part;
    
    
    //Using this more
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<JobPart> getJobParts(){
        return jobParts;
    }

    
    
//    @OneToMany(mappedBy = "jobSheet")
//    private List<Invoice> invoices;
    
    public JobSheet(Date dateBookedIn, String descriptionOfWork, String estimatedTime, String regNo) {
        this.dateBookedIn = dateBookedIn;
        this.descriptionOfWork = descriptionOfWork;
        this.estimatedTime = estimatedTime;
        this.regNo = regNo;
   }
    
    
    public JobSheet() {
    }
    
    public void addJobPart(JobPart jobPart){
        this.jobParts.add(jobPart);
    }

    @Id
    @Column(name = "JobNo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getJobNo() {
        return jobNo;
    }

    public void setJobNo(int jobNo) {
        this.jobNo = jobNo;
    }

    @Column(name = "DateBookedIn")
    public Date getDateBookedIn() {
        return dateBookedIn;
    }

    public void setDateBookedIn(Date dateBookedIn) {
        this.dateBookedIn = dateBookedIn;
    }

    @Column(name = "DescriptionOfWork")
    public String getDescriptionOfWork() {
        return descriptionOfWork;
    }

    public void setDescriptionOfWork(String descriptionOfWork) {
        this.descriptionOfWork = descriptionOfWork;
    }

    @Column(name = "DescriptionAfterWork")
    public String getDescriptionAfterWork() {
        return descriptionAfterWork;
    }

    public void setDescriptionAfterWork(String descriptionAfterWork) {
        this.descriptionAfterWork = descriptionAfterWork;
    }

    @Column(name = "EstimatedTime")
    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    @Column(name = "DateCompleted")
    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    @Column(name = "RegNo")
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    
    @Column(name = "Mechanic")
    public String getRMechanic() {
        return RMechanic;
    }
    
    @Column(name = "AccTime")
    public String getAccTime() {
        return accTime;
    }

    public void setAccTime(String accTime) {
        this.accTime = accTime;
    }
    
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VehicleId", insertable = false, updatable = false)
    public Vehicle getVehicle() {
        return vehicle;
    }

    

    

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MechanicId", insertable = false, updatable = false)
    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

//    public List<Invoice> getInvoices() {
//        return invoices;
//    }
//
//    public void setInvoices(List<Invoice> invoices) {
//        this.invoices = invoices;
//    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<JobSheet> getJobSheet() {
        return jobSheet;
    }

    public void setJobSheet(List<JobSheet> jobSheet) {
        this.jobSheet = jobSheet;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Part> getPart() {
        return part;
    }

    public void setPart(List<Part> part) {
        this.part = part;
    }

    public void setJobParts(Set<JobPart> parts) {
        this.jobParts = parts;
    }

    public void setRMechanic(String RMechanic) {
        this.RMechanic = RMechanic;
    }

    
    
    
    
}
