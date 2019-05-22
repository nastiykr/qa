package com.stc.tests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class CalculatorDataProviderXLSX {


    String xlFilePath = "src\\test\\java\\com\\stc\\tests\\inputsum.xlsx";

    // data for sum from xlsx
    @DataProvider(name = "fileXLSXData", parallel = true)
    public Object[][] FileData() throws IOException {
        Object[][] data = testData(xlFilePath);
        return data;
    }


    public Object[][] testData(String xlFilePath) throws IOException {
        // Открываем документ
        FileInputStream inputStream = new FileInputStream(new File(xlFilePath));

        // Получаем workbook
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Проверяем только первую книгу
        XSSFSheet sheet = workbook.getSheetAt(0);

        System.out.println("Счиатанные данные из XLSX-файла:");

        // TODO: 21.05.2019 get row count for excelData
        int arrayMaxRowCount = 8;
        int arrayMaxCellCount = 3;

        Object[][] excelData = new Object[arrayMaxRowCount][arrayMaxCellCount];

        for (int i=0; i < arrayMaxRowCount; i++)
        {
            Row row = sheet.getRow(i+1);

            Cell aCell = row.getCell(0); //A
            Cell bCell = row.getCell(1); //B
            Cell resultCell = row.getCell(2); //RESULT

            excelData[i][0] = Double.valueOf(aCell.getNumericCellValue()).toString();
            System.out.print(excelData[i][0] + " ");
            excelData[i][1] = Double.valueOf(bCell.getNumericCellValue()).toString();
            System.out.print(excelData[i][1] + " ");
            excelData[i][2] = resultCell.getNumericCellValue();
            System.out.println(excelData[i][2]);
        }

        workbook.close();
        return excelData;
    }
}