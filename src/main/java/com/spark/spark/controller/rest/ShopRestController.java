package com.spark.spark.controller.rest;

import com.spark.spark.model.Shop;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ShopRestController.SHOP_REST_URL)
public class ShopRestController extends CRUDRestController<Shop, Long>{
    public static final String SHOP_REST_URL = "shop";
    @Autowired
    ShopService shopService;
    @Override
    CRUDService<Shop, Long> getService() {
        return shopService;
    }
}
