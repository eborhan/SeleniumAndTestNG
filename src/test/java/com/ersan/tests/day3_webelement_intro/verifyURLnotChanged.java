package com.ersan.tests.day3_webelement_intro;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {
    public static void main(String[] args) {


        //The below is a very simple example of smoke test

        //open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to the specified webpage
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // save expected URL before clicking then button
        String expectedUrl = driver.getCurrentUrl();

        //click on Retrieve password button
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();

        //save actual URL after clicking the button
        String actualUrl = driver.getCurrentUrl();

        //verify that URL did not change
        if(actualUrl.equals(expectedUrl))
            System.out.println("PASS");
        else
            System.out.println("FAIL");

        driver.quit();








    }

}
