package com.spark.spark.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "пусто")
    private String brend;
    @NotNull(message = "пусто")
    private String y_name;
    @NotNull(message = "пусто")
    private String models;
    @NotNull(message = "пусто")
    private Integer price;
    @NotNull(message = "пусто")
    private Integer price_promo;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "пусто")
    private Date startPromo;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "пусто")
    private Date endPromo;
    @NotNull(message = "пусто")
    private Integer compensation;

}
