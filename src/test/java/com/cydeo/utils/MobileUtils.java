package com.cydeo.utils;

import io.appium.java_client.AppiumBy;

public class MobileUtils {

    public static void scrollIntoView(String str){

        String uiautomatertext = "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+str+"\"));";

        Driver.getDriver().findElement(new AppiumBy.ByAndroidUIAutomator(uiautomatertext));


    }


}
