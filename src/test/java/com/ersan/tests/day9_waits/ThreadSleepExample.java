package com.ersan.tests.day9_waits;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {
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
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        //static wait, but may be problematic for sites loaded in varying wait time.
        //static wait also increases regression suite.
        Thread.sleep(6000);

        //if using this when a website has a wait time --> ElementNotInteractableException: element not interactable
        driver.findElement(By.id("username")).sendKeys("MaxSmith");



    }
}
