package com.ersan.tests.day9_popups_tabs_frames;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/iframe");

        //1. Switching using name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith");

        //go back to the first frame (main HTML)
        //useful when switched to multiple frames

        driver.switchTo().defaultContent();

        //2. Switching using INDEX
        driver.switchTo().frame(0);

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with INDEX");

        driver.switchTo().parentFrame();

        //3. Switching using WEBELEMENT

        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH WEBELEMENT");

    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/nested_frames");

        //first switching to top frame since selenium sees only one html at a time (top frame has 3 sub-frames)
        driver.switchTo().frame("frame-top");

        //then switching to middle frame
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        // first switching to parent frame to control other sub-frames
        driver.switchTo().parentFrame();
        //then switching to another sub-frame
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //going back to main HTML and to frame 2

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());
    }

}
