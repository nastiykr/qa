package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SumTest {
    @Test
    public void calcNotNull() {
        Calculator calc = new Calculator();
        Assert.assertNotNull(calc);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "sumData", dataProviderClass = CalculatorDataProvider.class)
    public void sumNumbers(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), result);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "stringData", dataProviderClass = CalculatorDataProvider.class, expectedExceptions = {NumberFormatException.class})
    public void sumNumbersMistake(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), result);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "fileXLSXData", dataProviderClass = CalculatorDataProviderXLSX.class)
    public void sumNumbersFileXLSX(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), result);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "fileTXTData", dataProviderClass = CalculatorDataProviderTXT.class)
    public void sumNumbersFileTXT(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), result);
    }
}
