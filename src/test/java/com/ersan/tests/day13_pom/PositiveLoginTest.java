package com.ersan.tests.day13_pom;

import com.ersan.pages.LoginPage;
import com.ersan.tests.TestBase;
import com.ersan.utilities.ConfigurationReader;
import com.ersan.pages.LoginPage;
import com.ersan.tests.TestBase;
import com.ersan.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginbtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/", "verify login");
    }

    @Test
    public void loginAsStoreManager(){
        LoginPage loginPage = new LoginPage();

        //for another test, we should only change the keys to be extracted from ConfigurationReader
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

//        loginPage.userNameInput.sendKeys(username);
//        loginPage.passwordInput.sendKeys(password);
//        loginPage.loginbtn.click();

        loginPage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/", "verify login");

    }
    @Test
    public void loginAsStoreManager2(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoremanager();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/", "verify login");
    }

}
