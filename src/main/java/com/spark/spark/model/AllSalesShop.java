package com.spark.spark.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AllSalesShop {
    private String shop;
    private String name;
    private String distributionModel;
    private int remains;
    private int sale1;
    private int sale6;
    private int remainsCash1;
    private int remainsCash2;
    private List<AllSalesDistrShop> all;

    public AllSalesShop(String shop, String name, String distributionModel, int remains, int sale1, int sale6) {
        this.shop = shop;
        this.name = name;
        this.distributionModel = distributionModel;
        this.remains = remains;
        this.sale1 = sale1;
        this.sale6 = sale6;
    }
}
