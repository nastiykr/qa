package com.stc.tests;

import org.testng.annotations.DataProvider;

import java.io.File;


import java.io.*;
import java.util.Arrays;

public class CalculatorDataProviderTXT {

    String xlFilePath = "src\\test\\java\\com\\stc\\tests\\inputsum.txt";

    // data for sum from xlsx
    @DataProvider(name = "fileTXTData", parallel = true)
    public Object[][] FileData() throws IOException {
        Object[][] data = testDataTxt(xlFilePath);
        return data;
    }

    // построчное считывание файла
    public Object[][] testDataTxt(String xlFilePath) throws IOException, FileNotFoundException {


        int arrayMaxRowCount = 9;
        int arrayMaxCellCount = 3;
        int i = 0; //для подсчёта строк
        String line;//считываемая строка

        Object[][] txtData = new Object[arrayMaxRowCount][arrayMaxCellCount];

        File file = new File(xlFilePath);

        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);

        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);

        //i - идём по строкам, j - идём по столбцам

        System.out.println("Счиатанные данные из TXT-файла:");
        while ((line = reader.readLine()) != null) {
            String [] parts = line.split(";");

            for (int j = 0; j < Math.min(arrayMaxCellCount, parts.length); j++) {
                try {
                    txtData[i][j] = parts[j];
                    txtData[i][2] = Double.parseDouble(parts[j].replace(',','.'));
                } catch (ArrayIndexOutOfBoundsException ex) {
                    ex.printStackTrace();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
                System.out.println(txtData[i][j]);
            }
            i++;
        }
        return txtData;
    }
}