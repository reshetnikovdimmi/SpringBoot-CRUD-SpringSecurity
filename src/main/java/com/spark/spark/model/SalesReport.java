package com.spark.spark.model;

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
public class  SalesReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String characteristic;
    private String shop;
    private String nomenclature;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Date dateSale;

    @Transient
    private String suppliers;
    @Transient
    private String models;
    @Transient
    private Double compensation;
    @Transient
    private Date startPromo;
    @Transient
    private Date endPromo;

    public SalesReport(String characteristic, String shop, String nomenclature, Date dateSale, String suppliers, String models) {

        this.characteristic = characteristic;
        this.shop = shop;
        this.nomenclature = nomenclature;
        this.dateSale = dateSale;
        this.suppliers = suppliers;
        this.models = models;
    }

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "characteristic",referencedColumnName = "characteristic", insertable = false, updatable = false)
    public Invoices provider;

    @ManyToOne(targetEntity = PhoneMatrix.class, cascade = jakarta.persistence.CascadeType.REFRESH,fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "nomenclature",referencedColumnName = "distributionModel", insertable = false, updatable = false,foreignKey = @jakarta.persistence
            .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    public PhoneMatrix phoneMatrix;
}
