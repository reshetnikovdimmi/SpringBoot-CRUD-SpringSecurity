package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.model.Shop;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(ShopController.SHOP_URL)
public class ShopController extends CRUDController<Shop, Long> {
    @Autowired
    private ShopService shopServicee;
    //TODO: константы должны быть выше всех в определении + кажется нужен класс констант куда это можно вынести
    public static final String SHOP_URL = "ui/shop";
    public static final String SHOP_NAME = "shop";

    @Override
    String getEntityName() {
        return SHOP_NAME;
    }

    @Override
    CRUDService<Shop, Long> getService() {
        return shopServicee;
    }

    @Override
    Object getObj() {
        return new Shop();
    }

    @Override
    ExselFileImport<Shop> getExsel() {
        return null;
    }


}
