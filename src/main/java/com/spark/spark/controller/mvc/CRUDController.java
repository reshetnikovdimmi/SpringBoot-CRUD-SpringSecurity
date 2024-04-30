package com.spark.spark.controller.mvc;


import com.spark.spark.exsel.exportFile.ExselFileExporte;
import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.service.interf.CRUDService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.poi.util.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;


@Controller

public abstract class CRUDController<E, K> {

    abstract String getEntityName();

    abstract CRUDService<E, K> getService();

    abstract Object getObj();

    abstract ExselFileImport<E> getExsel();

    @GetMapping("/shop-list")
    public String showList(Model model) {
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", getService().findAll());
        return getEntityName() + "/shop-list";
    }


    @GetMapping("/delete/{id}")
    public String showRead(@PathVariable K id, Model model) {
        getService().deleteById(id);
        model.addAttribute("shop", getService().findAll());
        return getEntityName() + "/shop-list::Store";
    }

    @PostMapping("/create")
    public String showCreate(@ModelAttribute("shop") @Valid E object, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) getService().create(object);
        model.addAttribute("message", bindingResult.getFieldError());
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", getService().findAll());
        return getEntityName() + "/shop-list";
    }

    @PostMapping("/exsel-import")
    public String matrixT2Import(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {
        getService().deleteAll();
        getService().saveAll(getExsel().importExsel(fileImport));
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", getService().findAll());
        return getEntityName() + "/shop-list";
    }
    @GetMapping("/exsel-exporte")
    public void downloadExselFile(HttpServletResponse response) throws IOException, ParseException {

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=start.xlsx");
        ByteArrayInputStream inputStream = ExselFileExporte.exportFile();
        IOUtils.copy(inputStream, response.getOutputStream());

    }

}