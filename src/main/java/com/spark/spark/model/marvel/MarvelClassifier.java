package com.spark.spark.model.marvel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import jakarta.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class MarvelClassifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String RainbowNomenclature;
    private String ManufacturersArticle;
    private String Name;
}
