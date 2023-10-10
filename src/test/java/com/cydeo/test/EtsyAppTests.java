package com.cydeo.test;

import com.cydeo.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EtsyAppTests {
    @Test
    public void SignInTest() throws InterruptedException {
        AndroidDriver driver = Driver.getDriver();

        driver.findElement(By.id("com.etsy.android:id/btn_sign_in_dialog")).click();

        driver.findElement(By.id("com.etsy.android:id/clg_text_input")).sendKeys("areatha@uspeakw.com");

        Thread.sleep(3000);

        driver.hideKeyboard();

        driver.findElement(By.id("com.etsy.android:id/sign_in_button_email")).click();

        Thread.sleep(5000);

        String xpathLocator = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText";

        WebElement joinNeuPasswordField = driver.findElement(By.xpath(xpathLocator));

        Assertions.assertTrue(joinNeuPasswordField.isDisplayed());

        joinNeuPasswordField.sendKeys("Cybertek2020");

        Thread.sleep(1000);

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.widget.Button")).click();


        Thread.sleep(5000);

        Driver.closeDriver();
    }
}
