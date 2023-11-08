package com.ersan.tests.day2_webdriver_basics;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {

        //constructing a WebDriver object from the getDriver() method of the WebDriverFactory class
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Title = " + title);

    }

}
