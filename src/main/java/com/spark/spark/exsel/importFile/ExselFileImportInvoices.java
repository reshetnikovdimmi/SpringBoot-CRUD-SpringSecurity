package com.spark.spark.exsel.importFile;

import com.spark.spark.model.Invoices;
import com.spark.spark.model.PhoneMatrix;
import jakarta.persistence.Entity;
import lombok.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExselFileImportInvoices<E> extends ExselFileImport {

    public String provider;

    @Override
    public List<E> importExsel(MultipartFile matrixPhoneImport) throws IOException, ParseException {

        workbook = new XSSFWorkbook(matrixPhoneImport.getInputStream());

        worksheet = workbook.getSheetAt(0);

        list = new ArrayList();

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

            XSSFRow row = worksheet.getRow(i);

            Invoices phoneMatrix = new Invoices();

            phoneMatrix.setNomenclature(row.getCell(0).getStringCellValue());
            phoneMatrix.setCharacteristic(row.getCell(1).getStringCellValue());
            phoneMatrix.setPrice((int) row.getCell(2).getNumericCellValue());
            phoneMatrix.setSuppliers(provider);
            phoneMatrix.setDateInvoices(new java.sql.Date(new java.util.Date().getTime()));

            list.add(phoneMatrix);

        }

        return list;
    }

}
