package tests;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;
import page_objects.TrainTimetablePage;

public class TrainTimetableTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TrainTimetablePage trainTimetablePage = new TrainTimetablePage();

    @Test(description = "User can open Book ticket page by clicking on Book ticket link in Train timetable page")
    public void TC015() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoTrainTimetablePage();

        String expectedDepartStation = "Huế";
        String expectedArriveStation = "Sài Gòn";

        trainTimetablePage.clickBookTicketLnk(expectedDepartStation, expectedArriveStation);

        String expectedPageHeader = "Book ticket";
        String actualPageHeader = bookTicketPage.getPageHeader();

        Assert.assertEquals(actualPageHeader, expectedPageHeader, "Page header is incorrect");

        String actualDepartFromSelectedValue = bookTicketPage.getDepartFromSelectedValue();
        String actualArriveAtSelectedValue = bookTicketPage.getArriveAtSelectedValue();

        Assert.assertEquals(actualDepartFromSelectedValue, expectedDepartStation, "Selected value at Depart Form drop-down is incorrect");
        Assert.assertEquals(actualArriveAtSelectedValue, expectedArriveStation, "Selected value at Arrive At drop-down is incorrect");
    }
}
