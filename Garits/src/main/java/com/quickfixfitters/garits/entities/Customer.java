package com.quickfixfitters.garits.entities;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "CustomerID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;

    @Column(name = "Forename")
    private String forename;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "CustomerAddress")
    private String customerAddress;
    
    @Column(name = "Postcode")
    private String postcode;
    
    @Column(name = "TelNo")
    private String telNo;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

    @Column(name = "Email")
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerAccountId", nullable = false)
    private CustomerAccount customerAccount;

    public Customer(String forename, String surname, String customerAddress,
            String postcode, String telNo, String email) {
        this.forename = forename;
        this.surname = surname;
        this.customerAddress = customerAddress;
        this.postcode = postcode;
        this.telNo = telNo;
        this.email = email;
    }
/*
* Hibernate constructor
* */
    public Customer() {
    }

    /*
     * Gets CustomerID
     * */
    public int getCustomerID() {
        return customerID;
    }

    /*
     * Sets CustomerID
     * */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /*
     * Gets Forename
     * */
    public String getForename() {
        return forename;
    }

    /*
     * Sets Forename
     * */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /*
    * Gets Surname
    * */
    public String getSurname() {
        return surname;
    }

    /*
     * Sets Surname
     * */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /*
     * Gets Customer Address
     * */
    public String getCustomerAddress() {
        return customerAddress;
    }
    /*
     * Sets Customer Address
     * */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    /*
     * Gets Telephone number
     * */
    public String getTelNo() {
        return telNo;
    }
    /*
     * Sets Telephone number
     * */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /*
    *  Gets Email
    * */
    public String getEmail() {
        return email;
    }
    /*
     * Sets Email
     * */
    public void setEmail(String email) {
        this.email = email;
    }
    /*
    *  Gets Postcode
    * */
    public String getPostcode() {
        return postcode;
    }
    /*
     * Sets Postcode
     * */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    /*
    * Gets Customer Account
    * */
    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }
    /*
    * Sets Customer Account
    * */
    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }
    /*
    *  Gets Vehicles registered under this Customer
    * */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    /*
    *  Sets Vehicles registered under this Customer
    * */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
