package com.ersan.tests.day10_actions_js;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverTest() {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions --> a class containing all user interactions
        // creating an actions object with driver as an argument
        Actions actions = new Actions(driver);
        //moveToElement moving cursor to the target element
        actions.moveToElement(img1).perform();
        // If the action has been performed can be verified using the text to be appeared when the action is performed
        WebElement viewLink = driver.findElement(By.xpath("//*[.='View profile']"));

        Assert.assertTrue(viewLink.isDisplayed(), "verify viewLink is displayed");

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(2000);
        if (acceptAndClose.size() > 0) {
            acceptAndClose.get(0).click();
        } else if (acceptCookies.size() > 0) {
            acceptCookies.get(0).click();
        }

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        //if not working, try to accept cookies on the page and then sleep for 2 seconds
        actions.dragAndDrop(source, target).perform();

    }
    @Test

    public void dragAndDropChaining() throws InterruptedException {
        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(2000);
        if (acceptAndClose.size() > 0) {
            acceptAndClose.get(0).click();
        } else if (acceptCookies.size() > 0) {
            acceptCookies.get(0).click();
        }


        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        //if not working, try to accept cookies on the page and then sleep for 2 seconds (above)
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();

    }

}
