package com.quickfixfitters.garits1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StockLevel")
public class StockLevel {

    @Id
    @Column(name = "OrderNo")
    private int orderNo;

    @Column(name = "InitialStock")
    private int initialStock;

    @Column(name = "StockUnit")
    private int stockUnit;

    @Column(name = "UsedStock")
    private int usedStock;

    @Column(name = "DeliveryStock")
    private int deliveryStock;

    public StockLevel(int initialStock, int stockUnit, int usedStock, int deliveryStock) {
        this.initialStock = initialStock;
        this.stockUnit = stockUnit;
        this.usedStock = usedStock;
        this.deliveryStock = deliveryStock;
    }

    public StockLevel() {
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getInitialStock() {
        return initialStock;
    }

    public void setInitialStock(int initialStock) {
        this.initialStock = initialStock;
    }

    public int getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(int stockUnit) {
        this.stockUnit = stockUnit;
    }

    public int getUsedStock() {
        return usedStock;
    }

    public void setUsedStock(int usedStock) {
        this.usedStock = usedStock;
    }

    public int getDeliveryStock() {
        return deliveryStock;
    }

    public void setDeliveryStock(int deliveryStock) {
        this.deliveryStock = deliveryStock;
    }

    @Override
    public String toString() {
        return "StockLevel{" + "orderNo=" + orderNo + ", initialStock=" + initialStock + ", stockUnit=" + stockUnit + ", usedStock=" + usedStock + ", deliveryStock=" + deliveryStock + '}';
    }
}
