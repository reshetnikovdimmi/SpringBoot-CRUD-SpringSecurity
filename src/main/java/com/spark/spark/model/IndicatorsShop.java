package com.spark.spark.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class IndicatorsShop {
    private String shop;
    private int remains;
    private int sale1;
    private int sale2;
    private int needs;

}
