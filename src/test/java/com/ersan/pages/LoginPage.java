package com.ersan.pages;

import com.ersan.utilities.ConfigurationReader;
import com.ersan.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    //driver.findElement(By.id("prependedInput"))
    @FindBy(id = "prependedInput")
    public WebElement userNameInput;

    //driver.findElement(By.id("prependedInput2"))
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //driver.findElement(By.id("_submit"))
    @FindBy(id = "_submit")
    public WebElement loginbtn;

    // if findings more than one element, the method allow stroing the elements in a list
    //@FindBy(css = ".btn.btn-primary")
    //public List<WebElement> buttons;

    public void login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginbtn.click();

    }
    public void loginAsDriver() {

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginbtn.click();
    }
    public void loginAsStoremanager() {
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginbtn.click();


    }

}
