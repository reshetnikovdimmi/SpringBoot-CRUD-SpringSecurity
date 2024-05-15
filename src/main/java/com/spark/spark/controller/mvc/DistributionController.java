package com.spark.spark.controller.mvc;

import com.spark.spark.dto.DistributionDto;
import com.spark.spark.model.Cash;
import com.spark.spark.model.IndicatorsShop;
import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.repository.PhoneMatrixRepository;
import com.spark.spark.service.interf.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public abstract class DistributionController<E, K> {

    @Autowired
    private PhoneMatrixRepository phoneMatrixRepository;

    abstract String getEntityName();

    abstract CRUDService<E, K> getService();
    DistributionDto distributionDto;
    @GetMapping("/distribution")
    public String bonuses(Model model) {
        distributionDto = new DistributionDto();
        List<Cash> remainsCash = new ArrayList<>();
        Cash cash;
        for (int i = 0;i<10;i++){
            cash = new Cash("i/"+ i, 3, 4,cash());
            remainsCash.add(cash);
        }




        List<IndicatorsShop> indicatorsShopList = new ArrayList<>();
        IndicatorsShop indicatorsShop = new IndicatorsShop("iugugygy", 1, 2,3,4,indic());
        indicatorsShopList.add(indicatorsShop);
        for (int i = 0;i<100;i++){
            indicatorsShop = new IndicatorsShop("iugufzfzgnggygy", 12, 22,32,42,indic());
            indicatorsShopList.add(indicatorsShop);
        }

        distributionDto.setIndicatorsShoMult(indicatorsShopList);
        distributionDto.setIndicatorsShopList(indicatorsShopList);
        distributionDto.setRemainsCash(remainsCash);

        model.addAttribute("distribution", distributionDto);


        phoneMatrixRepository.findAll();

        return getEntityName() + "/distribution";
    }

    private List<IndicatorsShop> indic() {
        List<IndicatorsShop> indicatorsShopList = new ArrayList<>();
        IndicatorsShop indicatorsShop = new IndicatorsShop("iugugygy", 1, 2,3,4,null);
        indicatorsShopList.add(indicatorsShop);
        for (int i = 0;i<10;i++){
            indicatorsShop = new IndicatorsShop("iugufzfzgnggygy", 12, 22,32,42,null);
            indicatorsShopList.add(indicatorsShop);
        }
        return indicatorsShopList;
    }

    @GetMapping("/Sale")
    private String accessoriesCategoryMaxSale(@RequestParam String group, Model model) {

        model.addAttribute("distribution", distributionDto);
        return getEntityName() + "/distribution::cash";
    }
    @GetMapping("/shop")
    private String shop(@RequestParam String shop, Model model) {

        model.addAttribute("distribution", distributionDto);
        return getEntityName() + "/distribution::shop";
    }

    private List<Cash> cash() {

        List<Cash> remainsCash1 = new ArrayList<>();
        Cash cash1 = new Cash("iugugygy", 1, 2,null);
        remainsCash1.add(cash1);
        for (int i = 0;i<10;i++){
            cash1 = new Cash("i"+ "-"+i, i+1, i+2,null);
            remainsCash1.add(cash1);
        }
        return remainsCash1;
    }
}
