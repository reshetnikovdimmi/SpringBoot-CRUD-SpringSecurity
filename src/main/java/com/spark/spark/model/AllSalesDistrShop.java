package com.spark.spark.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AllSalesDistrShop {
    private String shop;
    private String name;
    private String distributionModel;
    private int remains;
    private int sale1;
    private int sale6;
    private int remainsCash1;
    private int remainsCash2;

    public AllSalesDistrShop(String shop, String name, String distributionModel, int remains, int sale1, int sale6) {
        this.shop = shop;
        this.name = name;
        this.distributionModel = distributionModel;
        this.remains = remains;
        this.sale1 = sale1;
        this.sale6 = sale6;
    }
}
