package com.spark.spark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import java.io.Serializable;


@Data
//TODO: @Data лучше избегать при работе с @Entity https://habr.com/ru/companies/haulmont/articles/564682/
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class ButtonMatrix implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "пусто")
    private String model;
    @NotEmpty(message = "пусто")
    private String brand;
    @Transient
    private Double price;

    public ButtonMatrix(Long id, String model, String brand, Double price) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "model",referencedColumnName = "nomenclature", insertable = false, updatable = false)
    public RetailPrices prices;


}
