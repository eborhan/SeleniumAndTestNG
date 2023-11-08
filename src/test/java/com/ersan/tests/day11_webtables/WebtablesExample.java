package com.ersan.tests.day11_webtables;

import com.ersan.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebtablesExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.xpath("//table[1]"));
        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
        //we will not use it since java sees the table as a whole string text

    }

    @Test
    public void getAllHeaders() {
        //how many columns?
        List<WebElement> headers = driver.findElements(By.xpath(" //table[1]//th"));
        System.out.println("headers.size() = " + headers.size());
        for (WebElement header : headers) {
            System.out.println(header.getText());

        }

    }

    @Test
    public void printTableSize() {
        //how many columns?
        List<WebElement> headers = driver.findElements(By.xpath(" //table[1]//th"));
        System.out.println("headers.size() = " + headers.size());

        //how many rows?
        List<WebElement> allRowsWithHeaders = driver.findElements(By.xpath("//table[1]//tr"));
        System.out.println("allRowsWithHeaders.size() = " + allRowsWithHeaders.size());

        //number of rows without headers(preferable)
        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath(" //table[1]/tbody/tr"));
        System.out.println("allRowsWithoutHeaders.size() = " + allRowsWithoutHeaders.size());


    }

    @Test
    public void getRow() {
        //print the second row info
        WebElement secondRow = driver.findElement(By.xpath("//table[1]/tbody/tr[2]"));
        System.out.println(secondRow.getText());

        // getting all rows dynamically
        List<WebElement> numRows = driver.findElements(By.xpath(" //table[1]/tbody/tr"));
        for (int i = 1; i <= numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[1]/tbody/tr[" + i + "]"));
            System.out.println(i + "- " + row.getText());

        }

    }

    @Test
    public void getAllCellsInOneRow() {
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[1]/tbody/tr[1]/td"));
        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());

        }


    }

    @Test
    public void gettinASingleCellByIndex() {
        WebElement singleCell = driver.findElement(By.xpath("//table[1]/tbody/tr[3]/td[5]"));
        System.out.println("singleCell.getText() = " + singleCell.getText());

    }

    @Test
    public void printAllCellsByIndex() {
        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberofColumns();

        System.out.println("rowNumber = " + rowNumber);
        System.out.println("columnNumber = " + columnNumber);

        //iterate thrugh each row on the table
        for (int i = 1; i <= rowNumber; i++) {
            //iterate through each cell in the row
            for (int j = 1; j <= columnNumber; j++) {

                String cellXpath = "//table[1]/tbody/tr[" + i + "]/td[" + j + "]";
                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());

            }
            System.out.println("----------------");

        }
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow() {
        String firstName = "Jason";

        String xpath = "//table[1]//td[.='"+firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());

    }

    private int getNumberofColumns() {
        List<WebElement> headers = driver.findElements(By.xpath(" //table[1]//th"));
        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath(" //table[1]/tbody/tr"));
        return allRowsWithoutHeaders.size();
    }
}
