package com.spark.spark.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DistributionPhoneRestController.SHOP_REST_URL)
public class DistributionPhoneRestController extends DistributionRestController {
    public static final String SHOP_REST_URL = "distribution";


}
