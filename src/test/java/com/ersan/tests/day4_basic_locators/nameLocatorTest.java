package com.ersan.tests.day4_basic_locators;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //make the browser fullscreen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        //sending full name
        driver.findElement(By.name("full_name")).sendKeys("Mike Smith");

        //sending email
        driver.findElement(By.name("email")).sendKeys("mike@cybertek.com");

        //clicking Sign up button
        driver.findElement(By.name("wooden_spoon")).click();

        driver.quit();
    }
}
