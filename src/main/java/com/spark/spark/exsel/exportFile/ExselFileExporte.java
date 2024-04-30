package com.spark.spark.exsel.exportFile;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ExselFileExporte {
    public static ByteArrayInputStream exportFile() {
        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheetStartPromo = workbook.createSheet("Start_Promo");
            Sheet sheetEndPromo = workbook.createSheet("End_Promo");
            Sheet extensionPromo = workbook.createSheet("Extension_Promo");

            Row startPromoRow = sheetStartPromo.createRow(0);
            Row endPromoRowPromoRow = sheetEndPromo.createRow(0);
            Row extensionPromoRowPromoRow = extensionPromo.createRow(0);

            CellStyle headlerCellStyle = workbook.createCellStyle();
            headlerCellStyle.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
            headlerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Cell startPromoRowCell = startPromoRow.createCell(0);
            startPromoRowCell.setCellValue("Наименование");
            startPromoRowCell.setCellStyle(headlerCellStyle);

            Cell endPromoRowPromoCell = endPromoRowPromoRow.createCell(0);
            endPromoRowPromoCell.setCellValue("Наименование");
            endPromoRowPromoCell.setCellStyle(headlerCellStyle);

            Cell extensionPromoRowCell = extensionPromoRowPromoRow.createCell(0);
            extensionPromoRowCell.setCellValue("Наименование");
            extensionPromoRowCell.setCellStyle(headlerCellStyle);

            startPromoRowCell = startPromoRow.createCell(1);
            startPromoRowCell.setCellValue("Старая цена");
            startPromoRowCell.setCellStyle(headlerCellStyle);

            extensionPromoRowCell = extensionPromoRowPromoRow.createCell(1);
            extensionPromoRowCell.setCellValue("Старая цена");
            extensionPromoRowCell.setCellStyle(headlerCellStyle);

            startPromoRowCell = startPromoRow.createCell(2);
            startPromoRowCell.setCellValue("Новая цена");
            startPromoRowCell.setCellStyle(headlerCellStyle);

            extensionPromoRowCell = extensionPromoRowPromoRow.createCell(2);
            extensionPromoRowCell.setCellValue("Новая цена");
            extensionPromoRowCell.setCellStyle(headlerCellStyle);

            endPromoRowPromoCell = endPromoRowPromoRow.createCell(1);
            endPromoRowPromoCell.setCellValue("Новая цена");
            endPromoRowPromoCell.setCellStyle(headlerCellStyle);

            startPromoRowCell = startPromoRow.createCell(3);
            startPromoRowCell.setCellValue("До...");
            startPromoRowCell.setCellStyle(headlerCellStyle);

            extensionPromoRowCell = extensionPromoRowPromoRow.createCell(3);
            extensionPromoRowCell.setCellValue("До...");
            extensionPromoRowCell.setCellStyle(headlerCellStyle);

            startPromoRowCell = startPromoRow.createCell(4);
            startPromoRowCell.setCellValue("Примечание");
            startPromoRowCell.setCellStyle(headlerCellStyle);

            extensionPromoRowCell = extensionPromoRowPromoRow.createCell(4);
            extensionPromoRowCell.setCellValue("Примечание");
            extensionPromoRowCell.setCellStyle(headlerCellStyle);

            endPromoRowPromoCell = endPromoRowPromoRow.createCell(2);
            endPromoRowPromoCell.setCellValue("Примечание");
            endPromoRowPromoCell.setCellStyle(headlerCellStyle);



            sheetStartPromo.autoSizeColumn(0);
            sheetStartPromo.autoSizeColumn(1);
            sheetStartPromo.autoSizeColumn(2);
            sheetStartPromo.autoSizeColumn(3);
            sheetStartPromo.autoSizeColumn(4);

            extensionPromo.autoSizeColumn(0);
            extensionPromo.autoSizeColumn(1);
            extensionPromo.autoSizeColumn(2);
            extensionPromo.autoSizeColumn(3);
            extensionPromo.autoSizeColumn(4);

            sheetEndPromo.autoSizeColumn(0);
            sheetEndPromo.autoSizeColumn(1);
            sheetEndPromo.autoSizeColumn(2);


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return new ByteArrayInputStream(outputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
