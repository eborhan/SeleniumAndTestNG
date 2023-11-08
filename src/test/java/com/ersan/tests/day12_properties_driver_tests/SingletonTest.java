package com.ersan.tests.day12_properties_driver_tests;

import com.ersan.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
    @Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = Driver.get();
        Thread.sleep(2000);
        driver.get("https://www.google.com");

        //Driver.closeDriver();
        // if not closing the browser, the webpage is replaced in the subsequent tests
    }
    @Test

    public void test3() throws InterruptedException {
        WebDriver driver = Driver.get();
        driver.get("http://www.amazon.com");
    }
}
