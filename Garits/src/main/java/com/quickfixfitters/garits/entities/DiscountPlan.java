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
    private Set<FlexibleBands> flexibleDiscount;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "discountPlan")
    private CustomerAccount customerAccount;

    public DiscountPlan() {
        this.fixedDiscount = 10;
        this.variableDiscount = 0;
    }
    /*
    * Gets Fixed Discount
    * */
    public float getFixedDiscount() {
        return fixedDiscount;
    }
    /*
    * Sets Fixed Discount
    * */
    public void setFixedDiscount(float fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }
    /*
    * Gets Variable Discount
    * */
    public float getVariableDiscount() {
        return variableDiscount;
    }
    /*
     * Sets Variable Discount
     * */
    public void setVariableDiscount(float variableDiscount) {
        this.variableDiscount = variableDiscount;
    }
    /*
    * Gets Flexible Discount
    * */
    public Set<FlexibleBands> getFlexibleDiscount() {
        return flexibleDiscount;
    }
    /*
    * Sets Flexible Discount
    * */
    public void setFlexibleDiscount(Set<FlexibleBands> flexibleDiscount) {
        this.flexibleDiscount = flexibleDiscount;
    }
    /*
    * Gets Discount Plan ID
    * */
    public int getDiscountPlanId() {
        return discountPlanId;
    }
    /*
    * Sets Discount Plan ID
    * */
    public void setDiscountPlanId(int discountPlanId) {
        this.discountPlanId = discountPlanId;
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
    
    
}
