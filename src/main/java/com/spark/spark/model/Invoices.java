package com.spark.spark.model;

import com.spark.spark.model.marvel.MarvelClassifier;
import com.spark.spark.model.marvel.RemainsMarvel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomenclature;

    private String characteristic;

    private Integer price;

    private String suppliers;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Date dateInvoices;

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "characteristic",referencedColumnName = "characteristic", insertable = false, updatable = false)
    public RemainsMarvel remainsMarvel;

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "characteristic",referencedColumnName = "characteristic", insertable = false, updatable = false)
    public SalesReport salesReport;

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "nomenclature",referencedColumnName = "RainbowNomenclature", insertable = false, updatable = false)
    public MarvelClassifier marvelClassifier;
}
