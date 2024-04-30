package com.spark.spark.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
@Controller
public class DownloadsController {



    @GetMapping("/downloads")
    public String downloads(Model model) {
        model.addAttribute("time", Instant.now());
        return "/downloads/downloads";
    }

    @PostMapping("/invoices-import")
    public String invoicesImport(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {

       // getService().saveAll(getExsel().importExsel(fileImport));

        return "/downloads/downloads";
    }
}
