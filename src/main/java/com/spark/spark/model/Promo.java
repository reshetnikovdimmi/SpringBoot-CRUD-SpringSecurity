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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotNull(message = "пусто")
    String brend;
    @NotNull(message = "пусто")
    String y_name;
    @NotNull(message = "пусто")
    String models;
    @NotNull(message = "пусто")
    Integer price;
    @NotNull(message = "пусто")
    Integer price_promo;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "пусто")
    Date startPromo;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "пусто")
    Date endPromo;
    @NotNull(message = "пусто")
    Integer compensation;

}
