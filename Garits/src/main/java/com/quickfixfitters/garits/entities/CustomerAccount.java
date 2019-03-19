package com.quickfixfitters.garits.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CustomerAccount")
public class CustomerAccount {

    @Id
    @Column(name = "CustomerAccountId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int customerAccountId;

    @Column(name = "PaymentOption")
    private String paymentOption;

    @Column(name = "DiscountPlanId")
    private String discountPlanId;

    @Column(name = "CustomerId")
    private int customerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CustomerId", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "customerAccount")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "customerAccount")
    private List<MOTReminder> motReminders;

    @OneToMany(mappedBy = "customerAccount")
    private List<DiscountPlan> discountPlans;

    public int getCustomerAccountId() {
        return customerAccountId;
    }

    public CustomerAccount(String paymentOption, String discountPlanId) {
        this.paymentOption = paymentOption;
        this.discountPlanId = discountPlanId;
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

    public String getDiscountPlanId() {
        return discountPlanId;
    }

    public void setDiscountPlanId(String discountPlanId) {
        this.discountPlanId = discountPlanId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}
