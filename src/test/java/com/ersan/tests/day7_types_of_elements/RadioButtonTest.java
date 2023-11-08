package com.ersan.tests.day7_types_of_elements;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement redBtn = driver.findElement(By.id("red"));

        //how to click the buttons
        redBtn.click();

        //if clicking the red button, the test case will fail

        //verify blue is selected but red is not

        Assert.assertTrue(blueBtn.isSelected(), "verify blue button is selected");
        Assert.assertFalse(redBtn.isSelected(), "verify red button is not selected");

        System.out.println("blueBtn.isSelected() = " + blueBtn.isSelected());
        System.out.println("redBtn.isSelected() = " + redBtn.isSelected());

        driver.quit();


    }
}
