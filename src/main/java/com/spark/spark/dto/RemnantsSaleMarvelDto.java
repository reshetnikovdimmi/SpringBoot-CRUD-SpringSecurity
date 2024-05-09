package com.spark.spark.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RemnantsSaleMarvelDto {
    public String  manufacturerArticle;
    public String  name;
    public Long  sale;
    public Long  remains;
}
