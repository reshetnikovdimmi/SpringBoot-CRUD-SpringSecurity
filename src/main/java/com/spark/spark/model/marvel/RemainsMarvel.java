package com.spark.spark.model.marvel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//TODO: @Data лучше избегать при работе с @Entity https://habr.com/ru/companies/haulmont/articles/564682/
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class RemainsMarvel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomenclature;
    private String characteristic;
}
