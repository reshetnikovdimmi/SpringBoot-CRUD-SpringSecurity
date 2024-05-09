package com.spark.spark.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class RetailPrices implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomenclature;
    private Double prices;
}
