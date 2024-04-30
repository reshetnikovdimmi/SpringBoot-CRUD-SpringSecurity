package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.model.Suppliers;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(SuppliersController.SUPPLIERS_URL)
public class SuppliersController extends CRUDController<Suppliers, Long> {
    @Autowired
    private SuppliersService suppliersService;

    public static final String SUPPLIERS_URL = "ui/suppliers";
    public static final String SUPPLIERS_NAME = "suppliers";

    @Override
    String getEntityName() {
        return SUPPLIERS_NAME;
    }

    @Override
    CRUDService<Suppliers, Long> getService() {
        return suppliersService;
    }

    @Override
    Object getObj() {
        return new Suppliers();
    }

    @Override
    ExselFileImport<Suppliers> getExsel() {
        return null;
    }


}
