package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.exsel.importFile.ExselFileImportInvoices;
import com.spark.spark.exsel.importFile.ExselFileImportRetailPrices;
import com.spark.spark.exsel.importFile.ExselFileImportSalesReport;
import com.spark.spark.model.Invoices;
import com.spark.spark.model.RetailPrices;
import com.spark.spark.model.SalesReport;
import com.spark.spark.repository.InvoicesRepository;
import com.spark.spark.repository.RetailPricesRepository;
import com.spark.spark.repository.SalesReportRepository;
import com.spark.spark.repository.SuppliersRepository;
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

    @GetMapping("/downloads")
    public String downloads(Model model) {

        model.addAttribute("suppliers", suppliersRepository.getListSuppliers());
        return "/downloads/downloads";
    }

    @PostMapping("/invoices-import")
    public String invoicesImport(@RequestParam("file") MultipartFile fileImport, @RequestParam String provider, Model model) throws IOException, ParseException {
        ExselFileImport<Invoices> exselFileImport = new ExselFileImportInvoices<>(provider);
        invoicesRepository.saveAll(exselFileImport.importExsel(fileImport));
        return "/downloads/downloads";
    }

    @PostMapping("/sales-report-import")
    public String salesReportImport(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {
        ExselFileImport<SalesReport> exselFileImport = new ExselFileImportSalesReport<>();
        salesReportRepositiry.saveAll(exselFileImport.importExsel(fileImport));
        return "/downloads/downloads";
    }

    @PostMapping("/retail-prices-import")
    public String retailPricesImport(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {
        ExselFileImport<RetailPrices> exselFileImport = new ExselFileImportRetailPrices<>();
        retailPricesRepository.deleteAll();
        retailPricesRepository.saveAll(exselFileImport.importExsel(fileImport));
        return "/downloads/downloads";
    }

}
