package com.cydeo.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebTestBase {
    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:automationName","UiAutomator2");
        desiredCapabilities.setCapability("appium:platformName","Android");
        desiredCapabilities.setCapability("appium:platformVersion","10.0");
        desiredCapabilities.setCapability("appium:deviceName","Pixel 3");
        desiredCapabilities.setCapability("appium:browserName","Chrome");
        URL url;
        try {
            url = new URL("http://localhost:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver = new RemoteWebDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
