package com.spark.spark.controller.mvc;

import com.spark.spark.dto.DistributionDto;
import com.spark.spark.model.AllSalesShop;
import com.spark.spark.model.MatrixT2;
import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.repository.MatrixT2Repository;
import com.spark.spark.repository.ShopRepository;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.util.mapper.MappingUtils;
import com.spark.spark.repository.PhoneMatrixRepository;
import com.spark.spark.service.util.mapper.Matrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public abstract class DistributionController<E, K> {

    @Autowired
    private PhoneMatrixRepository phoneMatrixRepository;

    @Autowired
    private MappingUtils mappingUtils;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private MatrixT2Repository matrixT2Repository;


    abstract String getEntityName();

    abstract List<MappingUtils> getRemains();

    abstract List<MappingUtils> getSale1();

    abstract List<MappingUtils> getSale6();

    abstract CRUDService<E, K> getService();

    abstract List<String> getModel();

    abstract List<AllSalesShop> matrixT2();


    @GetMapping("/distribution")
    public String createDto(Model model) {

        mappingUtils.setRemainsList(getRemains());
        mappingUtils.setSale1List(getSale1());
        mappingUtils.setSale6List(getSale6());
        mappingUtils.setMatrixT2(matrixT2());
        mappingUtils.setPhoneMatrix((List<PhoneMatrix>) getService().findAll());
        mappingUtils.setModel(getModel());
        mappingUtils.setShopMono(shopRepository.monoListShop());
        mappingUtils.setShopMulti(shopRepository.multListShop());

        mappingUtils.createAllSalesShops();

        model.addAttribute("distribution", mappingUtils.createDto());
        return getEntityName() + "/distribution";
    }

    @GetMapping("/Sale")
    private String accessoriesCategoryMaxSale(@RequestParam String group, Model model) {

        model.addAttribute("SumCash", mappingUtils.getModelDistributionCash(group));
        model.addAttribute("indicatorsShopList", mappingUtils.getModelDistributionShop(group));
        return getEntityName() + "/distribution::cash";
    }

    @GetMapping("/shop")
    private String shop(@RequestParam String shop, Model model) {
        model.addAttribute("all", mappingUtils.getAllShop(shop));

        return getEntityName() + "/distribution::shop";
    }


}
