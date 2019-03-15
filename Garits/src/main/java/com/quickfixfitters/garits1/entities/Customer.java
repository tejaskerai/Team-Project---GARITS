package com.quickfixfitters.garits1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "CustomerID")
    private int customerID;

    @Column(name = "Forename")
    private String forename;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "CustomerAddress")
    private String customerAddress;

    @Column(name = "TelNo")
    private int telNo;

    @Column(name = "Email")
    private String email;

    public Customer(String forename, String surname, String customerAddress, int telNo, String email) {
        this.forename = forename;
        this.surname = surname;
        this.customerAddress = customerAddress;
        this.telNo = telNo;
        this.email = email;
    }

    public Customer() {
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    public int getTelNo() {
        return telNo;
    }

    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", forename=" + forename + ", surname=" + surname + ", customerAddress=" + customerAddress + ", telNo=" + telNo + ", email=" + email + '}';
    }

}
