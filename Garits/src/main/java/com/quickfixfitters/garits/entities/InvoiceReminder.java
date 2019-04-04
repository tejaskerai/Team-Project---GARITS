package com.quickfixfitters.garits.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "InvoiceReminder")
public class InvoiceReminder {

    @Id
    @Column(name = "InvoiceRNo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceRNo;

    @Column(name = "Forename")
    private String forename;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "CustomerAddress")
    private String customerAddress;

    @Column(name = "Date")
    private Date date;

    @Column(name = "RegNo")
    private int regNo;

    @Column(name = "InvoiceNo")
    private int invoiceNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InvoiceNo", insertable = false, updatable = false)
    private Invoice invoice;

    public InvoiceReminder(String forename, String surname, String customerAddress, Date date, int regNo, int invoiceNo) {
        this.forename = forename;
        this.surname = surname;
        this.customerAddress = customerAddress;
        this.date = date;
        this.regNo = regNo;
        this.invoiceNo = invoiceNo;
    }
    /* Hibernate Constructor*/
    public InvoiceReminder() {
    }
    /*Gets Invoice Number*/
    public int getInvoiceRNo() {
        return invoiceRNo;
    }
    /*Sets Invoice Number*/
    public void setInvoiceRNo(int invoiceRNo) {
        this.invoiceRNo = invoiceRNo;
    }
    /*Gets Forename*/
    public String getForename() {
        return forename;
    }
    /*Sets Forename*/
    public void setForename(String forename) {
        this.forename = forename;
    }
    /*Gets Surname*/
    public String getSurname() {
        return surname;
    }
    /*Sets Surname*/
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /*Gets Customer Address*/
    public String getCustomerAddress() {
        return customerAddress;
    }
    /*Set Customer Address*/
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    /*Gets Date*/
    public Date getDate() {
        return date;
    }
    /*Sets Date*/
    public void setDate(Date date) {
        this.date = date;
    }
    /*Gets Registration plate number*/
    public int getRegNo() {
        return regNo;
    }
    /*Sets Registration plate number*/
    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }
    /*Gets Invoice number*/
    public int getInvoiceNo() {
        return invoiceNo;
    }
    /*Sets Invoice number*/
    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

}
