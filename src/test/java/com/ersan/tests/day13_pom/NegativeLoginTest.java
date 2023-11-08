package com.ersan.tests.day13_pom;

import com.ersan.pages.LoginPage;
import com.ersan.tests.TestBase;
import com.ersan.pages.LoginPage;
import com.ersan.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    @Test
    public void wrongPasswordTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.userNameInput.sendKeys("User1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginbtn.click();


        //driver.findElement(By.id("prependedInput")).sendKeys("User1");
        //driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
        //driver.findElement(By.id("_submit")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login", "verfiy password");

    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();
        loginPage.userNameInput.sendKeys("someuser");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginbtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login", "verfiy username");


    }
}
