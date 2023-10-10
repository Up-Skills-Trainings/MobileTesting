package com.cydeo.page;

import com.cydeo.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    public CalculatorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "com.google.android.calculator:id/op_mul")
    public WebElement multiply;

    @FindBy(id = "com.google.android.calculator:id/eq")
    public WebElement equals;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    public WebElement result;

    public void clickSingleDigit(int digit){
        String id = "com.google.android.calculator:id/digit_"+digit;
        WebElement number = Driver.getDriver().findElement(By.id(id));
        number.click();
    }


}
