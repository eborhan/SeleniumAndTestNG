package com.ersan.tests.day9_popups_tabs_frames;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void SwitchWindowsTest() {
        driver.get("http://practice.cybertekschool.com/windows");

        //getting title
        System.out.println("Title before new window: " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();
        // It does not matter getting the title after opening new window, because selenium is always oriented to current window.
        System.out.println("Title after new window: " + driver.getTitle());

        //the unique id of where the window is stored
        //System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle))
                driver.switchTo().window(handle);

        }
        // This makes sense after switching to the other tab
        System.out.println("Title after switching to new window: " + driver.getTitle());

    }
    @Test
    public void moreThan2Windows() {
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Before switch: " + driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        //loop through each window
        for (String handle : windowHandles) {
            //changing one by one
            driver.switchTo().window(handle);
            //whenever a title equals to the expected title
            if (driver.getTitle().equals("New Window"))
                //stop on that window
                break;

        }

    }
}
