package com.ersan.pages;


import com.ersan.utilities.BrowserUtils;
import com.ersan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    /*
 In general, a base page is constructed according to the page intended to be automated
 and contains some common methods and locators specific to that page coming from a utility (e.g., BrowserUtils)
  */

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    protected WebElement pageSubtitle;

    @FindBy(css = "#user-menu>a")
    protected WebElement userName;

    @FindBy(linkText = "Logout")
    protected WebElement logOutLink;

    @FindBy(linkText = "My User")
    protected WebElement myUser;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);

    }

    /*
     * @return page name; for example, Dashboard
     */
    public String getPageSubtitle() {
        //ant time we are verifying the page name or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
        //BrowserUtils.waitForStaleElement(pageSubtitle);
        return pageSubtitle.getText();
    }

    /*
     * waits until loader screen presents. If the loader screen does not pop up at all,
     * NoSuchElementException will be handled by a try/catch block
     * Thus, we can continue in any case
     */
    public void waitUntilLoaderScreenDisappear(){
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getUserName(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userName,5);
        return userName.getText();
    }

    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }

    public void goToMyUser(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickability(userName,5).click();
        BrowserUtils.waitForClickability(myUser,5).click();
    }

    /*
     * This method will navigate user to the specific module in Vytrack application.
     * For example, if the tab equals to "Activities", and the module equals to "Calls",
     * then the method will navigate the user to this page: http://qa2.vytrack.com/call/
     *
     * @return tab
     * @param module
     */
    public void navigateToModule(String tab, String module){
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            BrowserUtils.waitForClickability(By.xpath(tabLocator),5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        }catch (Exception e){
            BrowserUtils.clickWithWait(By.xpath(tabLocator),5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator),5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator),5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        }catch (Exception e){
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),5);
        }
    }


}

