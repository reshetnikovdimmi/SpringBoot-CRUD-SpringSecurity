package com.spark.spark.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
//TODO: к классам DTO можно добавлять суффикс. Например ArticleImeiMarvelDto
public class RemnantsSaleMarvel {
    public String  manufacturerArticle;
    public String  name;
    public Long  sale;
    public Long  remains;
}
