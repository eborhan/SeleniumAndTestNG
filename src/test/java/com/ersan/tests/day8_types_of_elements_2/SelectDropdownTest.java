package com.ersan.tests.day8_types_of_elements_2;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropDownElement);

        List<WebElement> options = stateDropdown.getOptions();

        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());

        }


    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropDownElement);

        //verify that the first selection is "Select a State"

        String expectedOption = "Select a State";

        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"verify first selection");


    }


}