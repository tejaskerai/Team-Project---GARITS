package com.quickfixfitters.garits.entities;


import java.util.Date;
import java.util.List;
import javax.persistence.*;

//Dunno wtf this entity is
@Entity
@Table(name = "MOTReminder")
public class MOTReminder {

    @Id
    @Column(name = "DiscountPlanId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int discountPlanId;

    @Column(name = "RenewalTestDate")
    private Date renewalTestDate;

    @Column(name = "CustomerAccountId")
    private int customerAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerAccountId", insertable = false, updatable = false)
    private CustomerAccount customerAccount;


    public MOTReminder(Date renewalTestDate, int customerId) {
        this.renewalTestDate = renewalTestDate;
        this.customerAccountId = customerId;
    }

    public MOTReminder() {
    }

    public int getDiscountPlanId() {
        return discountPlanId;
    }

    public void setDiscountPlanId(int discountPlanId) {
        this.discountPlanId = discountPlanId;
    }

    public Date getRenewalTestDate() {
        return renewalTestDate;
    }

    public void setRenewalTestDate(Date renewalTestDate) {
        this.renewalTestDate = renewalTestDate;
    }

    public int getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(int customerId) {
        this.customerAccountId = customerId;
    }

}
