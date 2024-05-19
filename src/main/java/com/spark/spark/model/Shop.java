package com.spark.spark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "пусто")
    private String login;
    @NotEmpty(message = "пусто")
    private String password;
    @NotEmpty(message = "пусто")
    private String role;
    private String shopRainbow;
    private String shopIskra;
    private String shopUNF;
    private String clusterIskra;
    private String clusterT2;
    private String clusterRtk;
    private String simT2;
    private String simMts;
    private String simBee;
    private String simMf;



}
