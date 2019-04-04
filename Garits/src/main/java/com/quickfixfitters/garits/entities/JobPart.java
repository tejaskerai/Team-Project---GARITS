package com.quickfixfitters.garits.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JobPart")
public class JobPart{
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private JobSheet jobSheet;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Part part;
    
    public JobSheet getjobSheet(){
        return jobSheet;
    }
    
    public Part getPart(){
        return part;
    }
    
    @Id
    @Column(name = "JobPartId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int JobPartId;
    
    @Column(name = "Quantity")
    private int quantity;

    /*Hibername Constructor*/
    public JobPart() {
    }

    public JobPart(JobSheet jobSheet, Part part, int JobPartId, int quantity) {
        this.jobSheet = jobSheet;
        this.part = part;
        this.JobPartId = JobPartId;
        this.quantity = quantity;
    }
   
    
    /*Gets Job Sheet*/
    public JobSheet getJobSheet(){
        return jobSheet;
    }
    
    
    /*Gets Job Part ID*/
    public int getJobPartId() {
        return JobPartId;
    }
    /*Sets Job Part ID*/
    public void setJobPartId(int JobPartId) {
        this.JobPartId = JobPartId;
    }
    /*Gets Quantity*/
    public int getQuantity() {
        return quantity;
    }
    /*Sets Quantity*/
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /*Sets Job Sheet*/
    public void setJobSheet(JobSheet jobSheet) {
        this.jobSheet = jobSheet;
    }
    /*Sets Part*/
    public void setPart(Part part) {
        this.part = part;
    }
    
    
}
