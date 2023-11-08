package com.ersan.tests.day10_file_uploading;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadingTest {
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
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");

        //locating Choose File

        WebElement chooseFile = driver.findElement(By.name("file"));
        // if an element has a "type = file", we can use sendKeys() to upload a file
        chooseFile.sendKeys("C:\\Users\\Hp\\Desktop\\file.txt"); // static way
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();
        //getting the file name from the browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        // verfying file name is file.txt
        Assert.assertEquals(actualFileName, "file.txt", "verify the text name");

        // This is the static way of uploading a text. Then, creating resources for a dynamic way...

    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/upload");

        //locating Choose File
        WebElement chooseFile = driver.findElement(By.name("file"));
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile";
        String fullPath = projectPath + "/" + filePath;
        chooseFile.sendKeys(fullPath);
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();
        //getting the file name from the browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        // verfying file name is file.txt
        Assert.assertEquals(actualFileName, "textfile", "verify the text name");

        // This is the dynamic way of uploading a text. Dynamic locating also works other computers
    }
}
