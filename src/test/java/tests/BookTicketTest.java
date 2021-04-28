package tests;

import common.Constant;
import common.helpers.Log;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.SuccessPage;

import java.util.Map;

public class BookTicketTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    SuccessPage successPage = new SuccessPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
    }

    @Test(description = "User can book a ticket")
    public void TC001() {

        String departDate = "5/1/2021";
        String departFrom = "Nha Trang";
        String arriveAt = "Phan Thiết";
        String seatType = "Soft seat";
        String ticketAmount = "1";
        String ticketPrice = "125000";

        Ticket ticket = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmount, ticketPrice);

        bookTicketPage.bookTicket(ticket);

        String actualTitlePage = bookTicketPage.getTitlePage();
        String expectTitlePage = "Safe Railway - Success";

        Assert.assertEquals(actualTitlePage, expectTitlePage);

        Map<String,String> actualInformationTicket = successPage.getAllInformationTicket();
        Map<String,String> expectedInformationTicket = ticket.getInformationTicket();

        Assert.assertEquals(actualInformationTicket, expectedInformationTicket);
    }
}
