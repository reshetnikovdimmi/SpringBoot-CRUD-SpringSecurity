package com.spark.spark.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
//TODO: к классам DTO можно добавлять суффикс. Например ArticleImeiMarvelDto
public class Xiaomi {
    public String  model;
    public Long  sale;
    public Long  remains;
}
