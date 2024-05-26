package com.spark.spark.model;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cash {
    private String model;
    private String nomenclature;
    private int remainsCash1;
    private int remainsCash2;

    public Cash(String model, int remainsCash1, int remainsCash2) {
        this.model = model;
        this.remainsCash1 = remainsCash1;
        this.remainsCash2 = remainsCash2;
    }
}
