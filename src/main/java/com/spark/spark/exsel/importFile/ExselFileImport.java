package com.spark.spark.exsel.importFile;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class ExselFileImport<E> {
    public XSSFWorkbook workbook;
    public XSSFSheet worksheet;
    List<E> list;

    public List<E> importExsel(MultipartFile matrixPhoneImport) throws IOException, ParseException {
        return list;
    }
}
