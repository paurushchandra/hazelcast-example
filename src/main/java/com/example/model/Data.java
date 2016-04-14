package com.example.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by user on 11/4/16.
 */
public class Data implements Serializable {

    private String assetId;
    private Double nav;
    private BigDecimal price;
    private Double strategy;

    public Data(String assetId, Double nav) {
        this.assetId = assetId;
        this.nav = nav;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Double getNav() {
        return nav;
    }

    public void setNav(Double nav) {
        this.nav = nav;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getStrategy() {
        return strategy;
    }

    public void setStrategy(Double strategy) {
        this.strategy = strategy;
    }
}
