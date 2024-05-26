package com.spark.spark.model;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class MatrixT2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String distributionModel;
    private String cluster;
    private int quantity;
    @Transient
    private String cluster1;
    @Transient
    private String cluster2;
    @Transient
    private String cluster3;
    @Transient
    private String cluster4;

     @ManyToOne(targetEntity = Shop.class, cascade = CascadeType.ALL,fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "cluster",referencedColumnName = "clusterIskra",  nullable=false, insertable=false, updatable=false,foreignKey = @jakarta.persistence
            .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    public Shop shopMulti;

  @ManyToOne(targetEntity = Shop.class, cascade = CascadeType.ALL,fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "cluster",referencedColumnName = "clusterT2", insertable = false, updatable = false,foreignKey = @jakarta.persistence
            .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    public Shop shopMono;

    public MatrixT2(String distributionModel, String cluster, int quantity) {
        this.distributionModel = distributionModel;
        this.cluster = cluster;
        this.quantity = quantity;
    }
}
