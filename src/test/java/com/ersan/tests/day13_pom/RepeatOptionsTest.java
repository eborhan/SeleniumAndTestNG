package com.ersan.tests.day13_pom;

import com.ersan.pages.CalendarEventsPage;
import com.ersan.pages.CreateCalendarEventsPage;
import com.ersan.pages.DashboardPage;
import com.ersan.pages.LoginPage;
import com.ersan.tests.TestBase;
import com.ersan.pages.CalendarEventsPage;
import com.ersan.pages.CreateCalendarEventsPage;
import com.ersan.pages.DashboardPage;
import com.ersan.pages.LoginPage;
import com.ersan.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    /*VERIFY RADIO BUTTONS
    Open a Chrome browser
    Login as driver
    Go to Activities -> Calendar Events
    Clink on Create Calendar Events
    Click on Repeat
    Verify that "Repeat every day" is checked
    Verify that "Repeat weekdays" is not checked
     */

    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //wait for loader mask to disappear --> should be added in the case of lower pc speed or internet speed

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "Verify repeat days is selected");

        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "Verify weekday is not selected");

    }

    /*VERIFY REPEAT OPTIONS
    Open a Chrome browser
    Login as driver
    Go to Activities -> Calendar Events
    Clink on Create Calendar Events
    Click on Repeat
    Verify that "Repeat every day" is checked
    Verify that repeat options are daily, weekly, monthly, and yearly, respectively
     */

    @Test
    public void test2() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //wait for loader mask to disappear --> should be added in the case of lower pc speed or internet speed

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();

        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");

        List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatsDropdown.getOptions();


        for (WebElement option : actualOptions) {
            actualList.add(option.getText());


        }

        //a ready method for creating a list of web element texts
        //List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);


        Assert.assertEquals(actualList,expectedList,"verify the lists");


    }


}
