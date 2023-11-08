package com.ersan.tests.day4_basic_locators;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameLocatorTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //print multiple buttons header
        System.out.println(driver.findElement(By.className("h3")).getText());

        driver.quit();
    }
}
