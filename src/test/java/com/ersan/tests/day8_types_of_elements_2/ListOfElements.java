package com.ersan.tests.day8_types_of_elements_2;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

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
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //saving the elements in a list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        //printing size of the buttons
        System.out.println("buttons.size() = " + buttons.size());

        //verfying the size of the buttons
        Assert.assertEquals(buttons.size(),6,"verify the number of elements");

        //printing each element in the list --> iter+Enter for shortcut for a for loop
        for (WebElement button : buttons) {
            System.out.println(button.getText());
            Assert.assertTrue(button.isDisplayed(),"verify buttons are displayed");

        }

        //clicking the second button
        buttons.get(1).click();


    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //findElements does not throw an exception
        List<WebElement> buttons = driver.findElements(By.tagName("buttonasdasdasd"));
        // In this case, the size of the list will be zero!
        System.out.println("buttons.size() = " + buttons.size());
    }
}
