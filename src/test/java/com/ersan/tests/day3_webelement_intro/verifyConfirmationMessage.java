package com.ersan.tests.day3_webelement_intro;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) {

        //open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to the specified page
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //defining expected email
        String expectedEmail = "mike@cybertekschool.com";

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys(expectedEmail);


        //getting the text of a web element
        //1. getText() --> works 99% and returns strings, except for input boxes
        //2. getAttribute() --> especially for input boxes
        String actualEmail = emailInputBox.getAttribute("value");

        //verify that the email is displayed in the input box
        if(actualEmail.equals(expectedEmail))
            System.out.println("PASS");
        else
            System.out.println("FAIL");

        //click on Retrieve password button
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();

        //verify the following confirmation message: "Your e-mail's been sent!"
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

        //save expected message
        String expectedMessage = "Your e-mail's been sent!";

        //save actual message
        String actualMessage = actualConfirmationMessage.getText();

        if(actualMessage.equals(expectedMessage))
            System.out.println("PASS");
        else {
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        //close the browser
        driver.quit();


    }
}
