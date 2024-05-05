package com.spark.spark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//TODO: @Data лучше избегать при работе с @Entity https://habr.com/ru/companies/haulmont/articles/564682/
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class SalesReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String characteristic;
    private String shop;
    private String nomenclature;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //TODO: пропущен private модификатор
    Date dateSale;
}
