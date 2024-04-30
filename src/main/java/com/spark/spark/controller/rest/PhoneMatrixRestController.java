package com.spark.spark.controller.rest;

import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.repository.PhoneMatrixRepository;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.PhoneMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping(PhoneMatrixRestController.PROMO_REST_URL)
public class PhoneMatrixRestController extends CRUDRestController<PhoneMatrix, Long> {
    @Autowired
    private PhoneMatrixRepository phoneMatrixRepository;

    @Autowired
    private PhoneMatrixService phoneMatrixService;

    public static final String PROMO_REST_URL = "phone-matrix";

    @Override
    CRUDService<PhoneMatrix, Long> getService() {
        return phoneMatrixService;
    }

    @GetMapping("/distribution-model")
    private HashMap<String, HashMap<String, List<String>>> dropDownListModels() {


        List<String> model = phoneMatrixRepository.getListModel();
        HashMap<String, HashMap<String, List<String>>> distributionModel = new HashMap<>();
        model.forEach(r -> distributionModel.put(r, getY_name(r)));
        return distributionModel;
    }

    private HashMap<String, List<String>> getY_name(String r) {
        List<String> y_name = phoneMatrixRepository.getListY_name(r);
        HashMap<String, List<String>> phone = new HashMap<>();
        y_name.forEach(y -> phone.put(y, phoneMatrixRepository.getListBrand(y)));
        return phone;
    }

}
