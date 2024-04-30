package com.spark.spark.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminController {
    @GetMapping("/admin")
    public String loginPage(Model model) {

        return "admin";
    }
}
