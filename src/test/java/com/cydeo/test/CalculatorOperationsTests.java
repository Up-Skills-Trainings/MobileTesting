package com.cydeo.test;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidBy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorOperationsTests {
    AndroidDriver driver;
    @BeforeEach
    public void SetUp(){
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        try {
            driver = new AndroidDriver(
                    new URL("http://localhost:4723"), options
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void AddOperation(){
        // locate 4 and 5, add them verify the result is correct
        WebElement four = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        four.click();
        WebElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        plus.click();
        WebElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        five.click();
        WebElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        equal.click();

        WebElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));

        String actualText = result.getText();
        int expResult = 9;

        Assertions.assertEquals(expResult, Integer.parseInt(actualText));



    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }
}
