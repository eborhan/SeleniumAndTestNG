package com.ersan.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ersan.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest { // copy-paste to TestBase

    //Used for initiating and building reports
    ExtentReports report;

    // Used for creating a HTML report file
    ExtentHtmlReporter htmlReporter;

    // defines a test, enables adding logs, authors, and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
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
    @Test
    public void test(){

        //naming the current test
        extentLogger = report.createTest("TC123 Login as Driver Test");

        //test steps
        extentLogger.info("Open a new Chrome browser");

        extentLogger.info("Go to bla bla URL");

        extentLogger.info("Enter driver username and password");

        extentLogger.info("Click Login");

        extentLogger.info("Verify logged in");

        //pass() --> marks the test case as passed
        extentLogger.pass("TC123 is passed");

    }

    @AfterMethod
    public void tearDown(){

        //this is when the report is actually generated
        report.flush();

    }
}
