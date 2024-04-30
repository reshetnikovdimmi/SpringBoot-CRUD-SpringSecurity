package com.spark.spark.exsel.importFile;

import com.spark.spark.model.PhoneMatrix;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ExselFileImportPhoneMatrix<E> extends ExselFileImport {
@Override
    public List<E> importExsel(MultipartFile matrixPhoneImport) throws IOException, ParseException {

        workbook = new XSSFWorkbook(matrixPhoneImport.getInputStream());

        worksheet = workbook.getSheetAt(0);

        list = new ArrayList();

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

            XSSFRow row = worksheet.getRow(i);

            PhoneMatrix phoneMatrix = new PhoneMatrix();

            phoneMatrix.setName(row.getCell(0).getStringCellValue());
            phoneMatrix.setY_name(row.getCell(1).getStringCellValue());
            phoneMatrix.setDistributionModel(row.getCell(2).getStringCellValue());
            phoneMatrix.setBrand(row.getCell(3).getStringCellValue());
            phoneMatrix.setModel(row.getCell(4).getStringCellValue());

            list.add(phoneMatrix);

        }

        return list;
    }

}
