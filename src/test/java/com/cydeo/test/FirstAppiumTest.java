package com.cydeo.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAppiumTest {
    @Test
    public void Test() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        AndroidDriver driver = new AndroidDriver(
                new URL("http://localhost:4723"), options
        );
        Thread.sleep(3000);
        try {

            System.out.println(driver.getDeviceTime());
        } finally {
            driver.quit();
        }
    }
}
