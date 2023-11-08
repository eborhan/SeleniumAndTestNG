package com.ersan.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ersan.utilities.BrowserUtils;
import com.ersan.utilities.ConfigurationReader;
import com.ersan.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    //Used for initiating and building reports
    protected ExtentReports report;

    // Used for creating an HTML report file
    protected ExtentHtmlReporter htmlReporter;

    // defines a test, enables adding logs, authors, and test steps
    protected ExtentTest extentLogger;


    @BeforeTest
    public void setUpTest(){

        //initialize the class
        report = new ExtentReports();

        //create a report path

        String projectpath = System.getProperty("user.dir");
        String path = projectpath + "/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        // attach html reporter to the report object
        report.attachReporter(htmlReporter);

        //title of the report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        driver.get(ConfigurationReader.get("url"));


    }

    @AfterMethod
    //ITestResult class describes the result of a test in TestNG
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        // if the test fails
        if(result.getStatus() == ITestResult.FAILURE){
            //record the name of the failed test case
            extentLogger.fail(result.getName());

            //take a screenshot and return location of the screenshot
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());

            //attach the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenshotPath);

            // capture the exception and attach it to the report
            extentLogger.fail(result.getThrowable());

        }
        Thread.sleep(2000);
        Driver.closeDriver();

    }

    @AfterTest
    public void tearDownTest(){

        //this is when the report is actually generated
        report.flush();

    }
}
