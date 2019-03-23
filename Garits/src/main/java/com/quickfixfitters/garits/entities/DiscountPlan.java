package com.quickfixfitters.garits.entities;

import java.util.ArrayList;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "DiscountPlan")
public class DiscountPlan {

    @Id
    @Column(name = "DiscountPlanId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountPlanId;

    @Column(name = "FixedDiscount")
    private float fixedDiscount;

    @Column(name = "VariableDiscount")
    private float variableDiscount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "BandId", nullable = false)
    private Set<FlexibleBands> flexibleDiscount;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "discountPlan")
    private CustomerAccount customerAccount;

    public DiscountPlan(float fixedDiscount, float variableDiscount, 
            Set<FlexibleBands> flexibleDiscount) {
        this.fixedDiscount = fixedDiscount;
        this.variableDiscount = variableDiscount;
        this.flexibleDiscount = flexibleDiscount;
    }

    public DiscountPlan() {
        this.fixedDiscount = 10;
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

    public Set<FlexibleBands> getFlexibleDiscount() {
        return flexibleDiscount;
    }

    public void setFlexibleDiscount(Set<FlexibleBands> flexibleDiscount) {
        this.flexibleDiscount = flexibleDiscount;
    }

    public int getDiscountPlanId() {
        return discountPlanId;
    }

    public void setDiscountPlanId(int discountPlanId) {
        this.discountPlanId = discountPlanId;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }
    
    
}
