package com.quickfixfitters.garits.entities;

import javax.persistence.*;

@Entity
@Table(name = "Part")
public class Part {

    @Id
    @Column(name = "PartCode", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partCode;

    @Column(name = "PartName")
    private String partName;

    @Column(name = "Manufacturer")
    private String manufacturer;

    @Column(name = "VehicleType")
    private String vehicleType;

    @Column(name = "Year")
    private String year;

    @Column(name = "Description")
    private String description;

    @Column(name = "UnitPrice")
    private float unitPrice;

    @Column(name = "LowLevelThreshold")
    private int lowLevelThreshold;

    @Column(name = "JobNo")
    private int jobNo;

    @Column(name = "OrderNo")
    private int orderNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JobNo", insertable = false, updatable = false)
    private JobSheet jobSheet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="OrderNo", insertable = false, updatable = false)
    private StockLevel stockLevel;

    public Part(String partName, String manufacturer, String vehicleType, String year, String description, float unitPrice, int lowLevelThreshold, int jobNo, int orderNo) {
        this.partName = partName;
        this.manufacturer = manufacturer;
        this.vehicleType = vehicleType;
        this.year = year;
        this.description = description;
        this.unitPrice = unitPrice;
        this.lowLevelThreshold = lowLevelThreshold;
        this.jobNo = jobNo;
        this.orderNo = orderNo;
    }

    public Part() {
    }

    public int getPartCode() {
        return partCode;
    }

    public void setPartCode(int partCode) {
        this.partCode = partCode;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getLowLevelThreshold() {
        return lowLevelThreshold;
    }

    public void setLowLevelThreshold(int lowLevelThreshold) {
        this.lowLevelThreshold = lowLevelThreshold;
    }

    public int getJobNo() {
        return jobNo;
    }

    public void setJobNo(int jobNo) {
        this.jobNo = jobNo;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

}
