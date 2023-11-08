package com.ersan.tests.day9_waits;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();
        WebElement usernameInput = driver.findElement(By.id("username"));

        // the element is already within the HTML but...
        // if not wait explicitly --> ElementNotInteractableException
        //usernameInput.sendKeys("MikeSmith");

        //HOW TO WAIT EXPLICITLY
        //create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //There are lots of examples of conditions
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        //wait.until(ExpectedConditions.alertIsPresent());

        usernameInput.sendKeys("MikeSmith");
    }
    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");


        //clicking Enable button
        driver.findElement(By.xpath("//*[.='Enable']")).click();

        //finding inputbox
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait wait = new WebDriverWait(driver,10);
        //WebDriverWait wait can be declared in BeforeTest
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("MikeSmith");


    }
}

