package com.ersan.tests.day14_extent_reports;

import com.ersan.pages.LoginPage;
import com.ersan.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest() {

        extentLogger = report.createTest("Wrong Password Test");  //name of the test

        LoginPage loginPage = new LoginPage();

        loginPage.userNameInput.sendKeys("User1");
        extentLogger.info("Enter username: User1"); //step 1

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password: somepassword"); // step 2

        loginPage.loginbtn.click();
        extentLogger.info("Click login button");// step 3

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/loginQWE", "verfiy password");
        extentLogger.info("Verify Page URL"); // step 4

        extentLogger.pass("Wrong Password Test is PASSED"); // final step

    }

    @Test
    public void wrongUsernameTest(){

        extentLogger = report.createTest("Wrong Username Test");  //name of the test

        LoginPage loginPage = new LoginPage();

        loginPage.userNameInput.sendKeys("someuser");
        extentLogger.info("Enter username: someuser"); //step 1

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter Password: UserUser123"); // step 2

        loginPage.loginbtn.click();
        extentLogger.info("Click login button");// step 3

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login", "verfiy username");
        extentLogger.info("Verify Page URL"); // step 4

        extentLogger.pass("Wrong Username Test is PASSED"); // final step


    }


}
