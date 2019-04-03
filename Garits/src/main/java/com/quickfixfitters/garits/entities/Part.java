package com.quickfixfitters.garits.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Part")
public class Part implements Serializable {

    private int id;
    
    private Set<JobPart> jobParts = new HashSet<JobPart>();
    
    private String partCode;
    
    private String partName;

    private String manufacturer;

    private String vehicleType;

    private float unitPrice;

    private int lowLevelThreshold;
    
    private int stockLevel;

//    @Column(name = "VariableDiscount", nullable = true)
//    private float variableDiscount;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "JobNo", insertable = false, updatable = false)
//    private JobSheet jobSheet;
    
    // Using this relation
    private JobSheet jobSheet;

    public void setJobParts(Set<JobPart> jobParts) {
        this.jobParts = jobParts;
    }

    // Using this more
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<JobPart> getJobParts(){
        return jobParts;
    }
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="OrderNo", insertable = false, updatable = false)
//    private StockLevel stockLevel;

    public Part(String partCode, String partName, String manufacturer, String vehicleType, float unitPrice, int lowLevelThreshold, int stockLevel) {
        this.partCode = partCode;
        this.partName = partName;
        this.manufacturer = manufacturer;
        this.vehicleType = vehicleType;
        this.unitPrice = unitPrice;
        this.lowLevelThreshold = lowLevelThreshold;
        this.stockLevel = stockLevel;
    }

    public Part() {
    }
    

    @Id
    @Column(name = "Id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "PartCode")
    public String getPartCode() {
        return partCode;
    }

    public void setPartCode(String partCode) {
        this.partCode = partCode;
    }

    @Column(name = "PartName")
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Column(name = "Manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name = "VehicleType")
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Column(name = "UnitPrice")
    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Column(name = "LowLevelThreshold")
    public int getLowLevelThreshold() {
        return lowLevelThreshold;
    }

    public void setLowLevelThreshold(int lowLevelThreshold) {
        this.lowLevelThreshold = lowLevelThreshold;
    }

    @Column(name = "StockLevel")
    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public JobSheet getJobSheet() {
        return jobSheet;
    }

    public void setJobSheet(JobSheet jobSheet) {
        this.jobSheet = jobSheet;
    }

//    public float getVariableDiscount() {
//        return variableDiscount;
//    }
//
//    public void setVariableDiscount(float variableDiscount) {
//        this.variableDiscount = variableDiscount;
//    }

    public void setJobPart(Set<JobPart> parts) {
        this.jobParts = parts;
    }

    public void addJobPart(JobPart jobPart){
        this.jobParts.add(jobPart);
    }
    
    
}
