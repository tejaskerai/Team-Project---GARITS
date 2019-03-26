package com.quickfixfitters.garits.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @Column(name = "InvoiceNO", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int InvoiceNo;

    @Column(name = "Qty")
    private int qty;

    @Column(name = "Item")
    private String item;

    @Column(name = "PartNo")
    private int partNo;

    @Column(name = "UnitCost")
    private float UnitCost;

    @Column(name = "Total")
    private float total;

    @Column(name = "VAT")
    private float vat;

    @Column(name = "CustomerForename")
    private String customerForename;

    @Column(name = "CustomerSurname")
    private String customerSurname;

    @Column(name = "CustomerAddress")
    private String customerAddress;

    @Column(name = "JobNo")
    private int jobNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JobNo", insertable = false, updatable = false)
    private JobSheet jobSheet;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceReminder> invoiceReminders;


    public Invoice(int qty, String item, int partNo, float UnitCost, float total, float vat, String customerForename, String customerSurname, String customerAddress, int jobNo) {
        this.qty = qty;
        this.item = item;
        this.partNo = partNo;
        this.UnitCost = UnitCost;
        this.total = total;
        this.vat = vat;
        this.customerForename = customerForename;
        this.customerSurname = customerSurname;
        this.customerAddress = customerAddress;
        this.jobNo = jobNo;
    }

    public Invoice() {
    }

    public int getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(int InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPartNo() {
        return partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public float getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(float UnitCost) {
        this.UnitCost = UnitCost;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public String getCustomerForename() {
        return customerForename;
    }

    public void setCustomerForename(String customerForename) {
        this.customerForename = customerForename;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getJobNo() {
        return jobNo;
    }

    public void setJobNo(int jobNo) {
        this.jobNo = jobNo;
    }

}
