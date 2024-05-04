package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.exsel.importFile.ExselFileImportPhoneMatrix;
import com.spark.spark.model.ButtonMatrix;
import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.repository.PhoneMatrixRepository;
import com.spark.spark.service.interf.ButtonMatrixService;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.PhoneMatrixService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ButtonMatrixController.BUTTON_MATRIX_URL)
public class ButtonMatrixController extends CRUDController<ButtonMatrix, Long> {

    @Autowired
    private ButtonMatrixService buttonMatrixService;

    public static final String BUTTON_MATRIX_URL = "ui/button-matrix";
    public static final String BUTTON_MATRIX_NAME = "button-matrix";

    @Override
    String getEntityName() {
        return BUTTON_MATRIX_NAME;
    }

    @Override
    CRUDService<ButtonMatrix, Long> getService() {
        return buttonMatrixService;
    }

    @Override
    Object getObj() {
        return new PhoneMatrix();
    }

    @Override
    ExselFileImport<ButtonMatrix> getExsel() {
        return null;
    }



}
