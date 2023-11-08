package com.ersan.tests.day13_pom;

import com.ersan.pages.CalendarEventsPage;
import com.ersan.pages.DashboardPage;
import com.ersan.pages.LoginPage;
import com.ersan.tests.TestBase;
import com.ersan.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    @Test
    public void test1(){

        LoginPage login = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        login.userNameInput.sendKeys(username);
        login.passwordInput.sendKeys(password + Keys.ENTER);

        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle = dashboardPage.getPageSubtitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify the subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.getPageSubtitle(), "Calendar Events", "verify subtitle");




    }

}
