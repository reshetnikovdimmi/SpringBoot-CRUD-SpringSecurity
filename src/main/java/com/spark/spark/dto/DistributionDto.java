package com.spark.spark.dto;

import com.spark.spark.model.AllSalesShop;
import com.spark.spark.model.Cash;
import com.spark.spark.model.IndicatorsShop;
import com.spark.spark.service.util.mapper.CreateDTO;
import lombok.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DistributionDto<T> implements CreateDTO {

    private List<Cash> remainsCash;
    private List<Cash> nameCash;
    private List<IndicatorsShop> indicatorsShopList;
    private List<IndicatorsShop> indicatorsShopMult;
    private List<AllSalesShop> allSalesShopList;
    List<T> matrix1;
    List<T> matrix;


}

