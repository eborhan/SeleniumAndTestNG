package com.ersan.tests.day5_xpath;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("selenium");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value = 'Go']")).click();

        Thread.sleep(2000);

        WebElement result =driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        System.out.println("Result = " + result.getText());

        Thread.sleep(2000);

        driver.quit();
    }
}
