package com.ersan.tests.day12_properties_driver_tests;

import com.ersan.tests.TestBase;
import com.ersan.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void loginTest(){
        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);
    }


}
