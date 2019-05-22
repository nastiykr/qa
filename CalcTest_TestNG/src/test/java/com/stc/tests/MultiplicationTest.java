package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest {
    @Test
    public void calcNotNull() {
        Calculator calc = new Calculator();
        Assert.assertNotNull(calc);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "multiplicationData", dataProviderClass = CalculatorDataProvider.class)
    public void multiplicationNumbers(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.multiplication(a,b), result);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "stringData", dataProviderClass = CalculatorDataProvider.class, expectedExceptions = {NumberFormatException.class})
    public void sumNumbersMistake(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), result);
    }
}