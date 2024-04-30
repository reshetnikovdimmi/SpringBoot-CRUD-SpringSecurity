package com.spark.spark.controller.mvc;

import com.spark.spark.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private ShopRepository shopRepository;
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("tests", shopRepository.findAll());
        return "auth/login";
    }
}
