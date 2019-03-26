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

    public InvoiceReminder() {
    }

    public int getInvoiceRNo() {
        return invoiceRNo;
    }

    public void setInvoiceRNo(int invoiceRNo) {
        this.invoiceRNo = invoiceRNo;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

}
