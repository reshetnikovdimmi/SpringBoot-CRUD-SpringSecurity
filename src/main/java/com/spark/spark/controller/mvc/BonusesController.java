package com.spark.spark.controller.mvc;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BonusesController {
    @GetMapping("/bonuses")
    public String bonuses(Model model) {
       // model.addAttribute("optionsShop",authorizationTt.getShopList());
      //  model.addAttribute("optionsPhone",phoneRepositoriy.getPhoneList());
      //  model.addAttribute("optionsProvider",suppliersRepositoriy.getProviderList());
      //  model.addAttribute("Amount",bonusesPaidRepository.findAll(Sort.by(Sort.Direction.DESC, "startPromo")));
        return "/bonuses/bonuses";
    }
}
