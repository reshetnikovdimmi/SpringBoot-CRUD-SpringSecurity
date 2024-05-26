package com.spark.spark.exsel.importFile;


import com.spark.spark.model.Remains;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class ExselFileImportRemains<E> extends ExselFileImport {
    @Override
    public List<E> importExsel(MultipartFile matrixPhoneImport) throws IOException, ParseException {

        workbook = new XSSFWorkbook(matrixPhoneImport.getInputStream());

        worksheet = workbook.getSheetAt(0);

        list = new ArrayList();

        for (int i = 2; i < worksheet.getPhysicalNumberOfRows()-1; i++) {

            XSSFRow row = worksheet.getRow(i);

            Remains remains = new Remains();

            remains.setShop(row.getCell(0).getStringCellValue());
            remains.setNomenclature(row.getCell(1).getStringCellValue());
            remains.setRemains((int) row.getCell(2).getNumericCellValue());


            list.add(remains);

        }

        return list;
    }
}
