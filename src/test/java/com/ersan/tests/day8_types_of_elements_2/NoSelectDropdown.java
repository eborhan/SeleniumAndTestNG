package com.ersan.tests.day8_types_of_elements_2;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {
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

        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        dropDownElement.click();

        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));

        System.out.println("elements.size() = " + dropdownOptions.size());
        Assert.assertEquals(dropdownOptions.size(),5,"verify size of options");

        for (WebElement options : dropdownOptions) {
            System.out.println(options.getText());

        }

        // click Yahoo
        dropdownOptions.get(2).click();



    }
}
