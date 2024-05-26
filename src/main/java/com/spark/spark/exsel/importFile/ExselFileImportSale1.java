package com.spark.spark.exsel.importFile;

import com.spark.spark.model.Remains;
import com.spark.spark.model.Sale1;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ExselFileImportSale1<E> extends ExselFileImport {
    @Override
    public List<E> importExsel(MultipartFile matrixPhoneImport) throws IOException, ParseException {

        workbook = new XSSFWorkbook(matrixPhoneImport.getInputStream());

        worksheet = workbook.getSheetAt(0);

        list = new ArrayList();

        for (int i = 3; i < worksheet.getPhysicalNumberOfRows()-1; i++) {

            XSSFRow row = worksheet.getRow(i);

            Sale1 remains = new Sale1();

            remains.setShop(row.getCell(0).getStringCellValue());
            remains.setNomenclature(row.getCell(3).getStringCellValue());
            remains.setSale((int) row.getCell(4).getNumericCellValue());


            list.add(remains);

        }

        return list;
    }
}
