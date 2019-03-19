package com.quickfixfitters.garits.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "StockLevel")
public class StockLevel {

    @Id
    @Column(name = "OrderNo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int orderNo;

    @Column(name = "InitialStock")
    private int initialStock;

    @Column(name = "StockUnit")
    private int stockUnit;

    @Column(name = "UsedStock")
    private int usedStock;

    @Column(name = "DeliveryStock")
    private int deliveryStock;

    @OneToMany(mappedBy = "stockLevel")
    private List<Part> parts;

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

}
