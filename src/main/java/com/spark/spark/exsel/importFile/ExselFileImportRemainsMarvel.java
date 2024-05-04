package com.spark.spark.exsel.importFile;

import com.spark.spark.model.SalesReport;
import com.spark.spark.model.marvel.RemainsMarvel;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExselFileImportRemainsMarvel<E> extends ExselFileImport {
@Override
    public List<E> importExsel(MultipartFile matrixPhoneImport) throws IOException, ParseException {

        workbook = new XSSFWorkbook(matrixPhoneImport.getInputStream());

        worksheet = workbook.getSheetAt(0);

        list = new ArrayList();

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows()-1; i++) {

            XSSFRow row = worksheet.getRow(i);

            RemainsMarvel salesReport = new RemainsMarvel();

            salesReport.setCharacteristic(row.getCell(0).getStringCellValue());
            salesReport.setNomenclature(row.getCell(1).getStringCellValue());

            list.add(salesReport);

        }

        return list;
    }

}
