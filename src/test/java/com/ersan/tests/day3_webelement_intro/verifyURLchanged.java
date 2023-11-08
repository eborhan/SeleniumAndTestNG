package com.ersan.tests.day3_webelement_intro;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) {

        //open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to the specified page
        driver.get("http://practice.cybertekschool.com/forgot_password");


        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys() --> send a keyboard action to the web element
        emailInputBox.sendKeys("mike@cybertek.com");

        //click on Retrieve password button
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();

        //defining expected URL
        String expectedtUrl = "http://practice.cybertekschool.com/email_sents";

        //save actual URL after clicking the button
        String actualtUrl = driver.getCurrentUrl();

        //verify that URL changed to "http://practice.cybertekschool.com/email_sent"
        if(actualtUrl.equals(expectedtUrl))
            System.out.println("PASS");
        else{
            System.out.println("FAIL");
            System.out.println("expectedtUrl = " + expectedtUrl);
            System.out.println("actualtUrl = " + actualtUrl);
        }

        driver.quit();

    }
}
