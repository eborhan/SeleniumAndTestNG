package com.ersan.tests.day9_popups_tabs_frames;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
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
        driver.get("http://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //clicking the button
        driver.findElement(By.xpath("//button[.='Confirm']")).click();

        //clicking NO button
        driver.findElement(By.xpath("//button[.='No']")).click();
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //clicking "Click for JS Alert" button
        driver.findElement(By.xpath("//button[1]")).click();

        //switching to JS Alert popup
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //clicking "Click for JS Confirm" button
        driver.findElement(By.xpath("//button[2]")).click();
        alert.dismiss();

        //clicking "Click for JS Prompt" button
        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("MikeSmith");
        alert.accept();

    }
}
