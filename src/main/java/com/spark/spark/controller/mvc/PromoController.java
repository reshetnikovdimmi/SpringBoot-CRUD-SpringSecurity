package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.model.Promo;
import com.spark.spark.repository.PromoRepository;
import com.spark.spark.service.impl.PromoServiceImpl;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.PromoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(PromoController.PROMO_URL)
public class PromoController extends CRUDController<Promo, Long> {

    @Autowired
    private PromoService promoService;

    @Autowired
    private PromoRepository promoRepository;

    @Autowired
    private PromoServiceImpl promoServiceImpl;

    public static final String PROMO_URL = "ui/promo";
    public static final String PROMO_NAME = "promo";

    //TODO: кажется что эти переменные не нужны, можно обойтись локальными
    java.util.Date utilDate;
    //TODO: кажется что эти переменные не нужны, можно обойтись локальными
    java.sql.Date sqlDate;

    @Override
    String getEntityName() {
        return PROMO_NAME;
    }

    @Override
    CRUDService<Promo, Long> getService() {
        return promoService;
    }

    @Override
    Object getObj() {
        return new Promo();
    }

    @Override
    ExselFileImport<Promo> getExsel() {
        return  null;
    }

    @PostMapping("/search")
    public String showSearch(@ModelAttribute("shop") Promo object, Model model) {
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", promoRepository.searchPromo(object.getBrend(), object.getY_name(), object.getModels(), object.getStartPromo() == null ? null : new java.sql.Date(object.getStartPromo().getTime()), object.getEndPromo() == null ? null : new java.sql.Date(object.getEndPromo().getTime())));
             return getEntityName() + "/shop-list";
    }

    @Override
    @GetMapping("/shop-list")
    public String showList(Model model) {
        utilDate = new java.util.Date();
        sqlDate = new java.sql.Date(utilDate.getTime());
        promoServiceImpl.loadTodayYesterday(sqlDate);
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", getService().findAll());
        model.addAttribute("promoExtension", promoServiceImpl.promoExtension());
        model.addAttribute("endpromo", promoServiceImpl.endPromo());
        model.addAttribute("startpromo", promoServiceImpl.startPromo());
        model.addAttribute("current_promo", promoRepository.currentPromo(sqlDate));
        return getEntityName() + "/shop-list" ;
    }

    @Override
    @PostMapping("/create")
    public String showCreate(@ModelAttribute("shop") @Valid Promo object, BindingResult bindingResult, Model model) {
        if(!bindingResult.hasErrors())getService().create(object);
        promoServiceImpl.loadTodayYesterday(sqlDate);
        model.addAttribute("message", bindingResult.getFieldError());
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", getService().findAll());
        model.addAttribute("promoExtension", promoServiceImpl.promoExtension());
        model.addAttribute("endpromo", promoServiceImpl.endPromo());
        model.addAttribute("startpromo", promoServiceImpl.startPromo());
        model.addAttribute("current_promo", promoRepository.currentPromo(sqlDate));
        return getEntityName() + "/shop-list";
    }

    @PostMapping("/search-by-date")
    public String searchDate(@RequestParam String showDate, Model model) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        utilDate = formatter.parse(showDate);
        sqlDate = new java.sql.Date(utilDate.getTime());
        promoServiceImpl.loadTodayYesterday(sqlDate);
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", getService().findAll());
        model.addAttribute("promoExtension", promoServiceImpl.promoExtension());
        model.addAttribute("endpromo", promoServiceImpl.endPromo());
        model.addAttribute("startpromo", promoServiceImpl.startPromo());
        model.addAttribute("current_promo", promoRepository.currentPromo(sqlDate));
        return getEntityName() + "/shop-list" ;
    }
}
