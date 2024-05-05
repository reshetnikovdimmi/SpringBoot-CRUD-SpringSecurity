package com.spark.spark.model;

import com.spark.spark.model.marvel.MarvelClassifier;
import com.spark.spark.model.marvel.RemainsMarvel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//TODO: @Data лучше избегать при работе с @Entity https://habr.com/ru/companies/haulmont/articles/564682/
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomenclature;

    private String characteristic;

    private Integer price;

    private String suppliers;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //TODO: пропущен private модификатор
    Date dateInvoices;

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "characteristic",referencedColumnName = "characteristic", insertable = false, updatable = false)
    //TODO: почему модификатор public, а не private?
    public RemainsMarvel remainsMarvel;

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "characteristic",referencedColumnName = "characteristic", insertable = false, updatable = false)
    //TODO: почему модификатор public, а не private?
    public SalesReport salesReport;

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "nomenclature",referencedColumnName = "RainbowNomenclature", insertable = false, updatable = false)
    //TODO: почему модификатор public, а не private?
    public MarvelClassifier marvelClassifier;
}
