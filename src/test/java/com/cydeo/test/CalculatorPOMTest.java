package com.cydeo.test;

import com.cydeo.page.CalculatorPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorPOMTest {
    CalculatorPage calculatorPage = new CalculatorPage();

    @Test
    public void multiplyTest(){
        calculatorPage.clickSingleDigit(5);
        calculatorPage.multiply.click();
        calculatorPage.clickSingleDigit(8);
        calculatorPage.equals.click();

        String result = calculatorPage.result.getText();

        Assertions.assertEquals(40,Integer.parseInt(result));
    }
}
