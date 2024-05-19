package com.spark.spark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class PhoneMatrix implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(targetEntity = Remains.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nomenclature", referencedColumnName = "distributionModel", insertable = false, updatable = false)
    private List<Remains> remainsList;

    @OneToMany(targetEntity = Sale1.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nomenclature", referencedColumnName = "distributionModel", insertable = false, updatable = false)
    public List<Sale1> sale1List;

    @OneToMany(targetEntity = Sale6.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nomenclature", referencedColumnName = "distributionModel", insertable = false, updatable = false)
    public List<Sale6> sale6List;
}
