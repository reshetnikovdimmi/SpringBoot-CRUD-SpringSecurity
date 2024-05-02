package com.spark.spark.exsel.importFile;

import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.model.SalesReport;
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

public class ExselFileImportSalesReport<E> extends ExselFileImport {
@Override
    public List<E> importExsel(MultipartFile matrixPhoneImport) throws IOException, ParseException {

        workbook = new XSSFWorkbook(matrixPhoneImport.getInputStream());

        worksheet = workbook.getSheetAt(0);

        list = new ArrayList();

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

            XSSFRow row = worksheet.getRow(i);

            SalesReport salesReport = new SalesReport();

            salesReport.setCharacteristic(row.getCell(0).getStringCellValue());
            salesReport.setShop(row.getCell(1).getStringCellValue());
            salesReport.setNomenclature(row.getCell(2).getStringCellValue());
            salesReport.setDateSale(dateString(row.getCell(3).getStringCellValue()));

            list.add(salesReport);

        }

        return list;
    }
    private Date dateString(String stringCellValue) throws ParseException {

        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss", Locale.ENGLISH);
        date = formatter.parse(stringCellValue);

        return date;
    }
}
