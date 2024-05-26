package com.spark.spark.exsel.importFile;

import com.spark.spark.model.MatrixT2;
import com.spark.spark.model.PhoneMatrix;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ExselFileImportMatrixT2<E> extends ExselFileImport {
    @Override
    public List<E> importExsel(MultipartFile matrixPhoneImport) throws IOException, ParseException {

        workbook = new XSSFWorkbook(matrixPhoneImport.getInputStream());

        worksheet = workbook.getSheetAt(0);

        list = new ArrayList();

        int cell = worksheet.getRow(0).getPhysicalNumberOfCells();
        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

            XSSFRow row = worksheet.getRow(i);
            for (int j = 1; j<cell;j++) {
                MatrixT2 matrixT2 = new MatrixT2();
                matrixT2.setDistributionModel(row.getCell(0).getStringCellValue());
                matrixT2.setCluster(String.format("%.0f",worksheet.getRow(0).getCell(j).getNumericCellValue()));
                matrixT2.setQuantity((int) row.getCell(j).getNumericCellValue());
                list.add(matrixT2);
            }

        }

        return list;
    }
}
