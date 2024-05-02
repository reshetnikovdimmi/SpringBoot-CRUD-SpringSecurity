package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.exsel.importFile.ExselFileImportRemainsMarvel;
import com.spark.spark.model.marvel.MarvelClassifier;
import com.spark.spark.model.marvel.RemainsMarvel;
import com.spark.spark.repository.RemainsMarvelRepository;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.MarvelClassifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

@Controller
@RequestMapping(MarwelController.MARVEL_URL)
public class MarwelController extends CRUDController<MarvelClassifier, Long> {

    @Autowired
    private MarvelClassifierService marvelClassifierService;

    @Autowired
    private RemainsMarvelRepository remainsMarvelRepository;

    public static final String MARVEL_URL = "ui/marwel";
    public static final String MARVEL_NAME = "marwel";

    
    @Override
    String getEntityName() {
        return MARVEL_NAME;
    }

    @Override
    CRUDService<MarvelClassifier, Long> getService() {
        return marvelClassifierService;
    }

    @Override
    Object getObj() {
        return new MarvelClassifier();
    }

    @Override
    ExselFileImport<MarvelClassifier> getExsel() {
        return null;
    }

    @PostMapping("/remains-marvel-exsel-import")
    public String remainsMarvelImport(@RequestParam("file") MultipartFile fileImport, Model model) throws IOException, ParseException {
        remainsMarvelRepository.deleteAll();
        remainsMarvelRepository.saveAll(new ExselFileImportRemainsMarvel().importExsel(fileImport));
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", getService().findAll());
        return getEntityName() + "/shop-list";
    }

}
