package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivisionTest {
    @Test
    public void calcNotNull() {
        Calculator calc = new Calculator();
        Assert.assertNotNull(calc);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "divisionData", dataProviderClass = CalculatorDataProvider.class)
    public void divisionNumbers(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.division(a,b), result);
    }

    @Test(dependsOnMethods = "calcNotNull", dataProvider = "stringData", dataProviderClass = CalculatorDataProvider.class, expectedExceptions = {NumberFormatException.class})
    public void sumNumbersMistake(String a, String b, double result) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), result);
    }
}