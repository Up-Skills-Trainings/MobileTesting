package com.cydeo.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



public class EtsyChromeTest extends WebTestBase{
    // this test case is for etsy webapp on chrome browser, not native app

    @Test
    public void searchTest(){
        // navigate to your webApp with driver
        driver.get("https://www.etsy.com");
        // locate search box: we DON'T use appium inspector, we use google dev tool
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        WebElement results = driver.findElement(By.xpath("(//span[contains(text(),'results')])[1]"));
        System.out.println("results = " + results.getText());


    }
}
