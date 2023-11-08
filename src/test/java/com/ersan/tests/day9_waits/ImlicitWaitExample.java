package com.ersan.tests.day9_waits;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImlicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        //dynamic wait --> waits until the element is loaded regardless of predetermined time
        // it can be located under @BeforeTest and works for all test cases
        // if an element is in HTML, implicitlyWait will not solve the problem. It is already there...
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.cssSelector("#finish"));

        System.out.println(element.getText());

    }
}
