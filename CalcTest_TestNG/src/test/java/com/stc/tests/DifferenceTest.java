package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DifferenceTest {
    @Test
    public void calcNotNull() {
        Calculator calc = new Calculator();
        Assert.assertNotNull(calc);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "differenceData", dataProviderClass = CalculatorDataProvider.class)
    public void differenceNumbers(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.difference(a,b), result);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "stringData", dataProviderClass = CalculatorDataProvider.class, expectedExceptions = {NumberFormatException.class})
    public void sumNumbersMistake(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), result);
    }
}
