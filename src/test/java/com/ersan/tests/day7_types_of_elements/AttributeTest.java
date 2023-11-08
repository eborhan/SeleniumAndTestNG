package com.ersan.tests.day7_types_of_elements;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueBtn = driver.findElement(By.cssSelector("#blue"));

        //get the value of "type" attribute
        System.out.println(blueBtn.getAttribute("type"));

        Assert.assertEquals(blueBtn.getAttribute("type"), "radio");

        //get the value of "name" attribute
        System.out.println(blueBtn.getAttribute("name"));

        //get the value of "checked" attribute
        System.out.println(blueBtn.getAttribute("checked"));

        //get the value of an non-exisiting attribute
        System.out.println(blueBtn.getAttribute("href"));



        System.out.println(blueBtn.getAttribute("outerHTML"));

        // testing name
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));

        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));


        System.out.println("Inner HTML: " + button2.getAttribute("innerHTML"));


        driver.quit();

    }
}
