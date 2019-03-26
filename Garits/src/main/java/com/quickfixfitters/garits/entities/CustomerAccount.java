package com.quickfixfitters.garits.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CustomerAccount")
public class CustomerAccount {

    @Id
    @Column(name = "CustomerAccountId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerAccountId;

    @Column(name = "PaymentOption")
    private String paymentOption;
    
    @Column(name = "Useable")
    private int useable;

//    @OneToMany(mappedBy = "customeraccount")
//    private List<Vehicle> vehicles;
//
//    @OneToMany(mappedBy = "customeraccount")
//    private List<MOTReminder> motReminders;
//   
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerAccount")
    private Customer customer;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DiscountPlanId", nullable = false)
    private DiscountPlan discountPlan;

    public int getCustomerAccountId() {
        return customerAccountId;
    }

    public CustomerAccount(String paymentOption, int useable) {
        this.paymentOption = paymentOption;
        this.useable = useable;
    }

    public CustomerAccount() {
    }

    public void setCustomerAccountId(int customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public List<Vehicle> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(List<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }
//
//    public List<MOTReminder> getMotReminders() {
//        return motReminders;
//    }
//
//    public void setMotReminders(List<MOTReminder> motReminders) {
//        this.motReminders = motReminders;
//    }
//
    public DiscountPlan getDiscountPlan() {
        return discountPlan;
    }

    public void setDiscountPlan(DiscountPlan discountPlan) {
        this.discountPlan = discountPlan;
    }

    public int getUsable() {
        return useable;
    }

    public void setUsable(int useable) {
        this.useable = useable;
    }
}
