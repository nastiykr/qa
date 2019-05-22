package com.stc.tests;

import org.testng.annotations.DataProvider;

import static java.lang.Float.NaN;

public class CalculatorDataProvider {
    //sum
    @DataProvider(name = "sumData", parallel = true)
    public Object[][] sumData() {
        return new Object[][]{
                {"0", "0", 0.0},
                {"0", "999999999", 999999999.0},
                {"1", "1000000000", 1000000001.0},
                {"-1", "1", 0.0},
                {"-1000000000", "-0.1", -1000000000.1},
                {"-999999999", "0.1", -999999998.9},
                {"-5.8", "3.68", -2.1199999999999997},
                {"254.3348", "7.3868", 261.7216},
                {"4E3", "34E4", 344000.0},
        };
    }

    //multiplication
    @DataProvider(name = "multiplicationData", parallel = true)
    public Object[][] multiplicationData() {
        return new Object[][]{
                {"0", "0", 0.0},
                {"0", "999999999", 0.0},
                {"1", "1000000000", 1000000000.0},
                {"-1", "1", -1.0},
                {"-1000000000", "-0.1", 100000000.0},
                {"-999999999", "0.1", -99999999.9},
                {"-5.8", "3.68", -21.344},
                {"254.3348", "7.3868", 1878.72030064},
                {"4E3", "34E4", 1360000000.0},
        };
    }

    //division
    @DataProvider(name = "divisionData", parallel = true)
    public Object[][] divisionData() {
        return new Object[][]{
                {"0", "0", NaN},
                {"0", "999999999", 0.0},
                {"1", "1000000000", 0.000000001},
                {"-1", "1", -1.0},
                {"-1000000000", "-0.1", 10000000000.0},
                {"-999999999", "0.1", -9999999990.0},
                {"-5.8", "3.68", -1.576086956521739},
                {"254.3348", "7.3868", 34.43098500027075},
                {"4E3", "34E4", 0.011764705882352941},
        };
    }

    //difference
    @DataProvider(name = "differenceData", parallel = true)
    public Object[][] differenceData() {
        return new Object[][]{
                {"0", "0", 0.0},
                {"0", "999999999", -999999999.0},
                {"1", "1000000000", -999999999.0},
                {"-1", "1", -2.0},
                {"-1000000000", "-0.1", -999999999.9},
                {"-999999999", "0.1", -999999999.1},
                {"-5.8", "3.68", -9.48},
                {"254.3348", "7.3868", 246.948},
                {"4E3", "34E4", -336000.0},
        };
    }

    //StringDataForAll
    @DataProvider(name = "stringData", parallel = true)
    public Object[][] StringData() {
        return new Object[][]{
                {"", "", NaN},
                {"1 000", "23", NaN},
                {"4,2", "74", NaN},
                {"2^2", "6", NaN},
                {"(3+2)*764", "99", NaN},
                {"22b5", "23G", NaN},
                {"b", "f", NaN},
                {"stringNumber", "secondNumberInput", NaN},
        };
    }
}
