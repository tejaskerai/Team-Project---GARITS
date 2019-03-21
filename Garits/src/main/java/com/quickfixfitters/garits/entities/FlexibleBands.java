/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickfixfitters.garits.entities;

/**
 *
 * @author ccram
 */
public class FlexibleBands {
    
    private float min;
    private float max;
    private float value;
    
    public FlexibleBands(float min, float max, float value){
        this.min = min;
        this.max = max;
        this.value = value;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
