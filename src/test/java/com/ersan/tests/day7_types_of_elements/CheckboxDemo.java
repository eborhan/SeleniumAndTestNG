package com.ersan.tests.day7_types_of_elements;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {
    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        //how to verify checkbox1 is not selected and the other is selected

        Assert.assertFalse(checkbox1.isSelected(), "verify checkbox1 is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify checkbox2 is selected");

        //clicking checkbox1

        checkbox1.click();

        //verfiying after selection

        Assert.assertTrue(checkbox1.isSelected(), "verify checkbox1 is selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify checkbox2 is selected");


        driver.quit();

    }
}