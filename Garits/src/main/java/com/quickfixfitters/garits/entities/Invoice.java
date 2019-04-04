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
    /*Hibernate Constructor*/
    public Invoice() {
    }
    /*Gets Invoice number*/
    public int getInvoiceNo() {
        return InvoiceNo;
    }
    /*Sets Invoice number*/
    public void setInvoiceNo(int InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }
    /*Get quantity*/
    public int getQty() {
        return qty;
    }
    /*Sets quantity*/
    public void setQty(int qty) {
        this.qty = qty;
    }
    /*Gets Item*/
    public String getItem() {
        return item;
    }
    /*Sets Item*/
    public void setItem(String item) {
        this.item = item;
    }
    /*Gets Part number*/
    public int getPartNo() {
        return partNo;
    }
    /*Sets Part number*/
    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }
    /*Gets Unit Cost*/
    public float getUnitCost() {
        return UnitCost;
    }
    /*Sets Unit Cose*/
    public void setUnitCost(float UnitCost) {
        this.UnitCost = UnitCost;
    }
    /*Gets Total price*/
    public float getTotal() {
        return total;
    }
    /*Sets Total price*/
    public void setTotal(float total) {
        this.total = total;
    }
    /*Gets VAT*/
    public float getVat() {
        return vat;
    }
    /*Sets VAT*/
    public void setVat(float vat) {
        this.vat = vat;
    }
    /*Gets Customer Forename*/
    public String getCustomerForename() {
        return customerForename;
    }
    /*Sets Customer Forename*/
    public void setCustomerForename(String customerForename) {
        this.customerForename = customerForename;
    }
    /*Gets Customer Surname*/
    public String getCustomerSurname() {
        return customerSurname;
    }
    /*Sets Customer Surname*/
    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }
    /*Gets Customer Address*/
    public String getCustomerAddress() {
        return customerAddress;
    }
    /*Set Customer Address*/
    public void setCustomer1Address(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    /*Gets Job number*/
    public int getJobNo() {
        return jobNo;
    }
    /*Sets Job number*/
    public void setJobNo(int jobNo) {
        this.jobNo = jobNo;
    }

}
