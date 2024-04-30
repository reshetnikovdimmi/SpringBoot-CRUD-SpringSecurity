package com.spark.spark.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class PhoneMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "пусто")
    private String name;
    @NotEmpty(message = "пусто")
    private String y_name;
    @NotEmpty(message = "пусто")
    private String distributionModel;
    @NotEmpty(message = "пусто")
    private String brand;
    @NotEmpty(message = "пусто")
    private String model;
}
