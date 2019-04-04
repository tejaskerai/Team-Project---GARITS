/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickfixfitters.garits.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ccram
 */
@Entity
@Table(name = "FlexibleBands")
public class FlexibleBands {
    
    @Id
    @Column(name = "BandId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bandId;
    
    @Column(name = "min")
    private float min;
    
    @Column(name = "max")
    private float max;
    
    @Column(name = "value")
    private float value;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private DiscountPlan discountPlan;
    
    public FlexibleBands(float min, float max, float value){
        this.min = min;
        this.max = max;
        this.value = value;
    }

    /*Gets smallest value*/
    public float getMin() {
        return min;
    }
    /* Sets smallest value*/
    public void setMin(float min) {
        this.min = min;
    }
    /* Gets biggest value*/
    public float getMax() {
        return max;
    }
    /*Sets biggest value*/
    public void setMax(float max) {
        this.max = max;
    }
    /*Gets value*/
    public float getValue() {
        return value;
    }
    /*Sets value*/
    public void setValue(float value) {
        this.value = value;
    }
    /*Gets Band ID*/
    public int getBandId() {
        return bandId;
    }
    /*Sets Band ID*/
    public void setBandId(int bandId) {
        this.bandId = bandId;
    }
    /*Gets Discount Plan*/
    public DiscountPlan getDiscountPlan() {
        return discountPlan;
    }
    /*Sets Discount Plan*/
    public void setDiscountPlan(DiscountPlan discountPlan) {
        this.discountPlan = discountPlan;
    }
    
    
}
