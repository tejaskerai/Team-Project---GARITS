package com.quickfixfitters.garits.entities;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "DiscountPlan")
public class DiscountPlan {

    @Id
    @Column(name = "DiscountPlanId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int discountPlanId;

    @Column(name = "FixedDiscount")
    private float fixedDiscount;

    @Column(name = "VariableDiscount")
    private float variableDiscount;

    @Column(name = "FlexibleDiscount")
    private ArrayList<FlexibleBands> flexibleDiscount;

    @Column(name = "CustomerAccountId")
    private int customerAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerAccountId", insertable = false, updatable = false)
    private CustomerAccount customerAccount;


    public DiscountPlan(float fixedDiscount, float variableDiscount, 
            ArrayList<FlexibleBands> flexibleDiscount) {
        this.fixedDiscount = fixedDiscount;
        this.variableDiscount = variableDiscount;
        this.flexibleDiscount = flexibleDiscount;
    }

    public DiscountPlan() {
    }

    public float getFixedDiscount() {
        return fixedDiscount;
    }

    public void setFixedDiscount(float fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }

    public float getVariableDiscount() {
        return variableDiscount;
    }

    public void setVariableDiscount(float variableDiscount) {
        this.variableDiscount = variableDiscount;
    }

    public ArrayList<FlexibleBands> getFlexibleDiscount() {
        return flexibleDiscount;
    }

    public void setFlexibleDiscount(ArrayList<FlexibleBands> flexibleDiscount) {
        this.flexibleDiscount = flexibleDiscount;
    }

    public int getDiscountPlanId() {
        return discountPlanId;
    }

    public void setDiscountPlanId(int discountPlanId) {
        this.discountPlanId = discountPlanId;
    }

    public int getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(int customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }
    
    
}
