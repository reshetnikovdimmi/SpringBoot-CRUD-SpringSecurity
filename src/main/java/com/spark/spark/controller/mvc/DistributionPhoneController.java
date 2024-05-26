package com.spark.spark.controller.mvc;

import com.spark.spark.model.AllSalesShop;
import com.spark.spark.model.MatrixT2;
import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.model.Shop;
import com.spark.spark.repository.MatrixT2Repository;
import com.spark.spark.repository.PhoneMatrixRepository;
import com.spark.spark.repository.ShopRepository;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.PhoneMatrixService;
import com.spark.spark.service.util.mapper.MappingUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(DistributionPhoneController.PHONE_URL)
public class DistributionPhoneController extends DistributionController<PhoneMatrix, Long> {

    public static final String PHONE_URL = "ui/distribution";
    public static final String PHONE_NAME = "distribution";

    @Autowired
    private PhoneMatrixRepository phoneMatrixRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private PhoneMatrixService phoneMatrixService;

    @Autowired
    private MatrixT2Repository matrixT2Repository;


    @Override
    String getEntityName() {
        return PHONE_NAME;
    }

    @Override
    List<MappingUtils> getRemains() {
        return phoneMatrixRepository.getRemains();
    }

    @Override
    List<MappingUtils> getSale1() {
        return phoneMatrixRepository.getSale1();
    }

    @Override
    List<MappingUtils> getSale6() {
        return phoneMatrixRepository.getSale6();
    }

    @Override
    CRUDService<PhoneMatrix, Long> getService() {
        return phoneMatrixService;
    }

    @Override
    List<String> getModel() {
        return phoneMatrixRepository.getListName();
    }

    @Override
    List<AllSalesShop> matrixT2() {
        List<AllSalesShop> a = matrixT2Repository.getMatrixT2ShopMulti();
        a.addAll(matrixT2Repository.getMatrixT2ShopMono());
        return a;
    }


}
