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
    
    @Column(name = "Useable")
    private int useable;
    
//    @OneToMany(mappedBy = "customeraccount")
//    private List<MOTReminder> motReminders;
//   
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerAccount")
    private Customer customer;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DiscountPlanId", nullable = false)
    private DiscountPlan discountPlan;


    /*
    *  Gets Customer Account ID
    * */
    public int getCustomerAccountId() {
        return customerAccountId;
    }


    public CustomerAccount(int useable) {
        
        this.useable = useable;
    }

    /*
    * Hibernate constructor
    * */
    public CustomerAccount() {
    }
    /*
    * Sets Customer Account ID
    * */
    public void setCustomerAccountId(int customerAccountId) {
        this.customerAccountId = customerAccountId;
    }
    /*
    * Gets Customer
    * */
    public Customer getCustomer() {
        return customer;
    }
    /*
    * Sets Customer
    * */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
//    public List<MOTReminder> getMotReminders() {
//        return motReminders;
//    }
//
//    public void setMotReminders(List<MOTReminder> motReminders) {
//        this.motReminders = motReminders;
//    }
//
    /*
    * Gets Discount Plan
    * */
    public DiscountPlan getDiscountPlan() {
        return discountPlan;
    }
    /*
    * Sets Discount Plan
    * */
    public void setDiscountPlan(DiscountPlan discountPlan) {
        this.discountPlan = discountPlan;
    }
    /*
    * Gets usable
    * */
    public int getUsable() {
        return useable;
    }
    /*
    * Sets usable
    * */
    public void setUsable(int useable) {
        this.useable = useable;
    }
}
