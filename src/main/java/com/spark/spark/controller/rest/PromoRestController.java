package com.spark.spark.controller.rest;

import com.spark.spark.model.Promo;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PromoRestController.PROMO_REST_URL)
public class PromoRestController extends CRUDRestController<Promo, Long> {

    @Autowired
    private PromoService promoService;
    public static final String PROMO_REST_URL = "promo";

    @Override
    CRUDService<Promo, Long> getService() {
        return promoService;
    }




}
