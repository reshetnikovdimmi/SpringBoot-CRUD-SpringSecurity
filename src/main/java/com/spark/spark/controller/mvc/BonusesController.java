package com.spark.spark.controller.mvc;

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
import java.util.Date;

@Controller
public class BonusesController {
    @Autowired
    private Bonuses bonuses;
    @GetMapping("/bonuses")
    public String bonuses(Model model) {
        model.addAttribute("localDate", LocalDate.now().withDayOfMonth(1));
        model.addAttribute("bonuses", bonuses.getAllBonuses(LocalDate.now().withDayOfMonth(1)));
        return "/bonuses/bonuses";
    }
    @PostMapping("/all-bonuses")
    public String allBonuses(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @DateTimeFormat(pattern = "yyyy-MM-dd") Date stop, Model model) throws ParseException {


        return "/bonuses/bonuses";
    }
}
