package com.quickfixfitters.garits.entities;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "CustomerID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerAccountId", insertable = false, updatable = false)
    private CustomerAccount customerAccount;

    public Customer(String forename, String surname, String customerAddress,
            int telNo, String email) {
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

}
