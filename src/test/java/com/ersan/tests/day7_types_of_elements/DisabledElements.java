package com.ersan.tests.day7_types_of_elements;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {
    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadiobtn = driver.findElement(By.id("green"));


        //how to check any web element is enabled

        Assert.assertFalse(greenRadiobtn.isEnabled(), "verify the green button is NOT enabled");

        driver.quit();
    }
    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        inputBox.sendKeys("Mike Smith");

        driver.quit();

    }
}
