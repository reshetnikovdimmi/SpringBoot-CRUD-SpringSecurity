package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.*;
import com.spark.spark.model.*;
import com.spark.spark.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

@Controller
public class DownloadsController {

    @Autowired
    private SuppliersRepository suppliersRepository;

    @Autowired
    private InvoicesRepository invoicesRepository;

    @Autowired
    private SalesReportRepository salesReportRepositiry;

    @Autowired
    private RetailPricesRepository retailPricesRepository;

    @Autowired
    private RemainsRepository remainsRepository;

    @Autowired
    private Sale1Repository sale1Repository;

    @Autowired
    private Sale6Repository sale6Repository;

    @GetMapping("/downloads")
    public String downloads(Model model) {
        model.addAttribute("time", "world");
        model.addAttribute("suppliers", suppliersRepository.getListSuppliers());
        return "/downloads/downloads";
    }

    @PostMapping("/invoices-import")
    public String invoicesImport(@RequestParam("file") MultipartFile fileImport, @RequestParam String provider, Model model) throws IOException, ParseException {
        ExselFileImport<Invoices> exselFileImport = new ExselFileImportInvoices<>(provider);
        invoicesRepository.saveAll(exselFileImport.importExsel(fileImport));
        model.addAttribute("time", "success");
        return "/downloads/downloads";
    }

    @PostMapping("/sales-report-import")
    public String salesReportImport(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {
        ExselFileImport<SalesReport> exselFileImport = new ExselFileImportSalesReport<>();
        salesReportRepositiry.saveAll(exselFileImport.importExsel(fileImport));
        model.addAttribute("time", "success");
        return "/downloads/downloads";
    }

    @PostMapping("/retail-prices-import")
    public String retailPricesImport(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {
        ExselFileImport<RetailPrices> exselFileImport = new ExselFileImportRetailPrices<>();
        retailPricesRepository.deleteAll();
        retailPricesRepository.saveAll(exselFileImport.importExsel(fileImport));
        model.addAttribute("time", "success");
        return "/downloads/downloads";
    }
    @PostMapping("/remains-import")
    public String remainsImport(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {
        ExselFileImport<Remains> exselFileImport = new ExselFileImportRemains<>();
        remainsRepository.deleteAll();
        remainsRepository.saveAll(exselFileImport.importExsel(fileImport));
        model.addAttribute("time", "success");
        return "/downloads/downloads";
    }

    @PostMapping("/sale1-import")
    public String sale1Import(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {
        ExselFileImport<Sale1> exselFileImport = new ExselFileImportSale1<>();
        sale1Repository.deleteAll();
        sale1Repository.saveAll(exselFileImport.importExsel(fileImport));
        model.addAttribute("time", "success");
        return "/downloads/downloads";
    }
    @PostMapping("/sale6-import")
    public String sale6Import(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {
        ExselFileImport<Sale6> exselFileImport = new ExselFileImportSale6<>();
        sale6Repository.deleteAll();
        sale6Repository.saveAll(exselFileImport.importExsel(fileImport));
        model.addAttribute("time", "success");
        return "/downloads/downloads";
    }

}
