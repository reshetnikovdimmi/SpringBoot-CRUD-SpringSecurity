package com.spark.spark.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //TODO: пропущен private модификатор
    Long id;
    @NotNull(message = "пусто")
    //TODO: пропущен private модификатор + опечатка в имени brand?
    String brend;
    @NotNull(message = "пусто")
    //TODO: пропущен private модификатор  и имя не camelCase
    String y_name;
    @NotNull(message = "пусто")
    //TODO: пропущен private модификатор
    String models;
    @NotNull(message = "пусто")
    //TODO: пропущен private модификатор
    Integer price;
    @NotNull(message = "пусто")
    //TODO: пропущен private модификатор и имя не camelCase
    Integer price_promo;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //TODO: пропущен private модификатор
    @NotNull(message = "пусто")
    Date startPromo;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "пусто")
    //TODO: пропущен private модификатор
    Date endPromo;
    @NotNull(message = "пусто")
    //TODO: пропущен private модификатор
    Integer compensation;

}
