package com.spark.spark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
