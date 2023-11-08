package com.ersan.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class GetTitleAndUrl {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting the title and use Alt+Enter to create an automatic variable
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        //getting current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URl = " + currentUrl);

        //getting page source
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }
}
