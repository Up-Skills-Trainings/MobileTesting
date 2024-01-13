package com.cydeo.test;

import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceLabAppTest {
    @Test
    public void SignInTest() throws InterruptedException {

        AndroidDriver driver = Driver.getDriver();

        // locate userName
        driver.findElement(new AppiumBy.ByAccessibilityId("test-Username")).sendKeys(ConfigurationReader.getProperty("userName"));

        // locate password field
        driver.findElement(new AppiumBy.ByAccessibilityId("test-Password")).sendKeys(ConfigurationReader.getProperty("password"));

        // locate login button
        driver.findElement(new AppiumBy.ByAccessibilityId("test-LOGIN")).click();

        Thread.sleep(5000);

        WebElement aSampleProduct = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]"));

       Assertions.assertTrue(aSampleProduct.getText().contains("Sauce"));

        // How to scroll down in this mobile app

     //  MobileUtils.scrollIntoView("Privacy Policy");

      //  Thread.sleep(3000);

       System.out.println(driver.getDeviceTime());

        Driver.closeDriver();

    }


    @Test
    public void verifyItemTextTest() throws InterruptedException {
        // log into saucelab app, navigate to a product click, then verify its name/price

        AndroidDriver driver = Driver.getDriver();

        WebElement userNameBox = driver.findElement(new AppiumBy.ByAccessibilityId("test-Username"));
        userNameBox.sendKeys(ConfigurationReader.getProperty("userName"));
        // locate password field
        driver.findElement(new AppiumBy.ByAccessibilityId("test-Password")).sendKeys(ConfigurationReader.getProperty("password"));

        // locate login button
        driver.findElement(new AppiumBy.ByAccessibilityId("test-LOGIN")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")).click();

        Thread.sleep(3000);

        WebElement textLocator = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]"));

        String actualText = textLocator.getText();
        String expectedText = "Sauce Labs Backpack";

        Assertions.assertEquals(expectedText,actualText);
    }
}
