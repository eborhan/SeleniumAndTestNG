package com.ersan.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        // making a browser ready for operations
        WebDriverManager.chromedriver().setup();

        // selecting and deploying a browser
        WebDriver driver = new ChromeDriver();

        //get(url) method to navigate a webpage
        driver.get("http://www.amazon.com");
    }

}
