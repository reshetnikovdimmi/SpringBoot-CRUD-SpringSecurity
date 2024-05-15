package com.spark.spark.controller.mvc;

import com.spark.spark.repository.ShopRepository;
import com.spark.spark.repository.SuppliersRepository;
import com.spark.spark.service.bonuses.Bonuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class BonusesController {
    @Autowired
    private Bonuses bonuses;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private SuppliersRepository suppliersRepository;
    @GetMapping("/bonuses")
    public String bonuses(Model model) {
        model.addAttribute("localDate", LocalDate.now().withDayOfMonth(1));
        model.addAttribute("bonuses", bonuses.getAllBonuses(LocalDate.now().withDayOfMonth(1), null));
        model.addAttribute("shopss", bonuses.getAllBonuse());
        model.addAttribute("tests", shopRepository.findAll());
        model.addAttribute("suppliers", suppliersRepository.findAll());
        return "/bonuses/bonuses";
    }

    @PostMapping("/all-bonuses")
    public String allBonuses(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @DateTimeFormat(pattern = "yyyy-MM-dd") Date stop, Model model) throws ParseException {
        model.addAttribute("localDate", start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        model.addAttribute("bonuses", bonuses.getAllBonuses(start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), stop.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
        model.addAttribute("shopss", bonuses.getAllBonuse());
        model.addAttribute("tests", shopRepository.findAll());
        model.addAttribute("suppliers", suppliersRepository.findAll());
        return "/bonuses/bonuses";
    }
    @PostMapping("/search-bonuses")
    public String searchBonuses(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startAll, @DateTimeFormat(pattern = "yyyy-MM-dd") Date endAll, Model model) throws ParseException {
        model.addAttribute("localDate", startAll.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        model.addAttribute("bonuses", bonuses.getAllBonuses(startAll.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), endAll.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
        model.addAttribute("shopss", bonuses.getAllBonuse());
        model.addAttribute("tests", shopRepository.findAll());
        model.addAttribute("suppliers", suppliersRepository.findAll());
        return "/bonuses/bonuses";
    }

}
