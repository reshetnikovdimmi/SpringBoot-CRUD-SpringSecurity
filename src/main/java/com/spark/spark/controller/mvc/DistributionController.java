package com.spark.spark.controller.mvc;

import com.spark.spark.dto.DistributionDto;
import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.repository.ShopRepository;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.util.mapper.MappingUtils;
import com.spark.spark.repository.PhoneMatrixRepository;
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


    DistributionDto distributionDto;

    abstract String getEntityName();

    abstract List<MappingUtils> getRemains();
    abstract List<MappingUtils> getSale1();
    abstract List<MappingUtils> getSale6();
    abstract CRUDService<E, K> getService();
    abstract List<String> getModel();


    @GetMapping("/distribution")
    public String bonuses(Model model) {
        distributionDto = new DistributionDto();
        mappingUtils.setRemainsList(getRemains());
        mappingUtils.setSale1List(getSale1());
        mappingUtils.setSale6List(getSale6());

        distributionDto.setAllSalesShopList(mappingUtils.createAllSalesShop((List<PhoneMatrix>) getService().findAll(),shopRepository.getShopList()));

        distributionDto.setRemainsCash(mappingUtils.getCashMadelSum(getModel()));
        distributionDto.setIndicatorsShopMult(mappingUtils.getIndicatorShop(shopRepository.getShopList()));
        distributionDto.setIndicatorsShopList(mappingUtils.getIndicatorShop(shopRepository.getShopList()));

        model.addAttribute("distribution", distributionDto);
        return getEntityName() + "/distribution";
    }

    @GetMapping("/Sale")
    private String accessoriesCategoryMaxSale(@RequestParam String group, Model model) {

        model.addAttribute("SumCash",mappingUtils.getModelDistributionCash(group, (List<PhoneMatrix>) getService().findAll()));
        model.addAttribute("indicatorsShopList",mappingUtils.getModelDistributionShop(group,shopRepository.getShopList()));
        return getEntityName() + "/distribution::cash";
    }

    @GetMapping("/shop")
    private String shop(@RequestParam String shop, Model model) {
        model.addAttribute("all",mappingUtils.getAllShop(shop));
        return getEntityName() + "/distribution::shop";
    }


}
