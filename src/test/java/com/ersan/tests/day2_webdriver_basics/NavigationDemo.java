package com.ersan.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(2000);

        //navigate to another page with selenium
        driver.navigate().to("https://facebook.com");

        Thread.sleep(2000);

        //returning to previous page with selenium
        driver.navigate().back();

        Thread.sleep(2000);

        //forwarding to previous page with selenium
        driver.navigate().forward();

        //refreshing the webpage
        driver.navigate().refresh();

    }
}
