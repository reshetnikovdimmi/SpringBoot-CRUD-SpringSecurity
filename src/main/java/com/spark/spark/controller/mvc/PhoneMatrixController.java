package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.exsel.importFile.ExselFileImportPhoneMatrix;
import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.repository.PhoneMatrixRepository;
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
@RequestMapping(PhoneMatrixController.PROMO_MATRIX_URL)
public class PhoneMatrixController extends CRUDController<PhoneMatrix, Long> {

    @Autowired
    private PhoneMatrixService phoneMatrixService;

    @Autowired
    private PhoneMatrixRepository phoneMatrixRepository;

    public static final String PROMO_MATRIX_URL = "ui/phone-matrix";
    public static final String PROMO_MATRIX_NAME = "phone-matrix";

    @Override
    String getEntityName() {
        return PROMO_MATRIX_NAME;
    }

    @Override
    CRUDService<PhoneMatrix, Long> getService() {
        return phoneMatrixService;
    }

    @Override
    Object getObj() {
        return new PhoneMatrix();
    }

    @Override
    ExselFileImport<PhoneMatrix> getExsel() {
        return new ExselFileImportPhoneMatrix<>();
    }

    @Override
    @PostMapping("/create")
    public String showCreate(@ModelAttribute("shop") @Valid PhoneMatrix object, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (object.getId() != null) {
                PhoneMatrix phoneMatrix = getService().findById(object.getId());
                if (!phoneMatrix.getName().equals(object.getName())) {
                    phoneMatrixRepository.updateName(object.getName(), phoneMatrix.getName());
                }
            }
            getService().create(object);
        }

        model.addAttribute("message", bindingResult.getFieldError());
        model.addAttribute("shop1", getObj());
        model.addAttribute("shop", getService().findAll());
        return getEntityName() + "/shop-list";
    }

}
