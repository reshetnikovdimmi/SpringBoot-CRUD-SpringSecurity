package com.spark.spark.controller.rest;

import com.spark.spark.model.AllSalesShop;
import com.spark.spark.service.util.mapper.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class DistributionRestController  {
    @Autowired
    private MappingUtils mappingUtils;
    @PostMapping("update")
    public ResponseEntity update(@RequestBody AllSalesShop object) {
        return ResponseEntity.ok(mappingUtils.distributionDto( object));
    }
}
