package com.spark.spark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "пусто")
    private String name;
    @NotEmpty(message = "пусто")
    private String email;
    @NotEmpty(message = "пусто")
    private String number;
    @NotEmpty(message = "пусто")
    private String manager;


}
