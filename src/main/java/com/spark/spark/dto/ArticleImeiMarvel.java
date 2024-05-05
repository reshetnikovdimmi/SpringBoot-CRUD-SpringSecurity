package com.spark.spark.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
//TODO: к классам DTO можно добавлять суффикс. Например ArticleImeiMarvelDto
public class ArticleImeiMarvel {

    public String manufacturerArticle;
    public String imei;

}
