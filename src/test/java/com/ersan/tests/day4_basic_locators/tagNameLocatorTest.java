package com.ersan.tests.day4_basic_locators;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tagNameLocatorTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.tagName("input")).sendKeys("Mike Smith with TagName");

        driver.findElement(By.name("email")).sendKeys("mike@cybertek.com");

        driver.findElement(By.tagName("button")).click();

        driver.quit();
    }
}
