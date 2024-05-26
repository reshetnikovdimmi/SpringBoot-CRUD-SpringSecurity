package com.spark.spark.controller.mvc;

import com.spark.spark.exsel.importFile.ExselFileImportMatrixT2;
import com.spark.spark.exsel.importFile.ExselFileImport;
import com.spark.spark.model.MatrixT2;
import com.spark.spark.model.Shop;
import com.spark.spark.service.interf.CRUDService;
import com.spark.spark.service.interf.MatrixT2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(MatrixT2Controller.MATRIX_T2_URL)
public class MatrixT2Controller extends CRUDController<MatrixT2, Long> {

    public static final String MATRIX_T2_URL = "ui/matrixT2";
    public static final String MATRIX_T2_NAME = "matrixT2";

    @Autowired
    private MatrixT2Service matrixT2Service;

    @Override
    String getEntityName() {
        return MATRIX_T2_NAME;
    }

    @Override
    CRUDService<MatrixT2, Long> getService() {
        return matrixT2Service;
    }

    @Override
    Object getObj() {
        return new Shop();
    }

    @Override
    ExselFileImport<MatrixT2> getExsel() {
        return new ExselFileImportMatrixT2<>();
    }
}
