package com.cydeo.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {

    private static AndroidDriver driver;

    private static URL url;

    private static UiAutomator2Options caps = new UiAutomator2Options();

    private Driver(){

    }

    public static AndroidDriver getDriver(){
        String platform = ConfigurationReader.getProperty("platform");
        if(Objects.isNull(driver)){
            switch (platform){
                case "android-calculator":
                    caps.setCapability("appium:app","https://cybertek-appium.s3.amazonaws.com/calculator.apk");
                    try {
                        url = new URL("http://localhost:4723");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url,caps);
                    break;
                case "android-etsy":
                    caps.setCapability("appium:app","https://cybertek-appium.s3.amazonaws.com/etsy.apk");
                    caps.setCapability("appPackage","com.etsy.android");
                    caps.setCapability("appActivity","com.etsy.android.ui.user.auth.SignInActivity");
                    try {
                        url = new URL("http://localhost:4723");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url,caps);
                    break;
                case "android-saucelabapp":
                    // change the case to point to local test drive
                    String testDir = System.getProperty("user.dir");
                    caps.setCapability("appium:app",testDir+"Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    caps.setCapability("appPackage","com.swaglabsmobileapp");
                    caps.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
                    try {
                        url = new URL("http://localhost:4723");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url,caps);
                    break;
                case "android-saucelabapp-remote":
                    MutableCapabilities capsR = new MutableCapabilities();
                    capsR.setCapability("platformName", "Android");
                    capsR.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
                    capsR.setCapability("appium:platformVersion", "current_major");
                    capsR.setCapability("appium:deviceOrientation", "PORTRAIT");
                    capsR.setCapability("appium:automationName", "UiAutomator2");
                    // Application Set-Up
                    capsR.setCapability("appium:app","https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    capsR.setCapability("appPackage","com.swaglabsmobileapp");
                    capsR.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    // below line should be your personal access key and username
                    sauceOptions.setCapability("username", "oauth-oscar-602b1");
                    sauceOptions.setCapability("accessKey", "ffa4f06b-6dc8-4c9a-ae04-696336415e31");
                    sauceOptions.setCapability("build", "Cydeo01");
                    sauceOptions.setCapability("name", "Training Remote Testing");
                    capsR.setCapability("sauce:options", sauceOptions);

                    try {
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, capsR);
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(Objects.nonNull(driver)){
            driver.quit();
            driver = null;
        }
    }
}
