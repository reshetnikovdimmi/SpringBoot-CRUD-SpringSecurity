package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.model.SalesReport;
import com.spark.spark.model.Shop;
import com.spark.spark.repository.SalesReportRepository;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ShopController.MATRIX_T2_URL)
public class ShopController extends CRUDController<Shop, Long> {

    public static final String MATRIX_T2_URL = "ui/shop";
    public static final String SHOP_NAME = "shop";

    @Autowired
    private ShopService shopServicee;

    @Autowired
    private SalesReportRepository salesReportRepository;


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

    @Override
    @PostMapping("/create")
    public String showCreate(@ModelAttribute("shop") @Valid Shop object, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (object.getId() != null) {
                Shop shop = getService().findById(object.getId());
                if (!shop.getShopIskra().equals(object.getShopIskra())) {
                    salesReportRepository.updateShop(object.getShopIskra(), shop.getShopIskra());
                }
            }
            getService().create(object);
        }

        model.addAttribute("message", bindingResult.getFieldError());
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", getService().findAll());
        return getEntityName() + "/shop-list";
    }
}
