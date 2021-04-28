package tests;

import common.Constant;
import common.Common;
import common.helpers.DataHelper;
import common.helpers.Log;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

import java.util.Map;

public class BookTicketTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can book a ticket")
    public void TC001() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();

        String departDate = Common.plusDayFromNow(5, Constant.FORMAT_DATE);
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

        Map<String, String> actualInformationTicket = bookTicketPage.getAllTicketInformation();
        Map<String, String> expectedInformationTicket = ticket.getInformationTicket();

        Assert.assertEquals(actualInformationTicket, expectedInformationTicket);
    }

    @Test(description = "Error message is displayed when total number of booked tickets is more than 10")
    public void TC002() {
        homePage.gotoRegisterPage();

        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomText();
        String confirmPassword = password;
        String pid = DataHelper.getRandomPID();

        registerPage.register(email, password, confirmPassword, pid);

        registerPage.gotoLoginPage();
        loginPage.login(email, password);

        bookTicketPage.gotoBookTicketPage();

        String departDate = Common.plusDayFromNow(5, Constant.FORMAT_DATE);
        String departFrom = "Nha Trang";
        String arriveAt = "Phan Thiết";
        String seatType = "Soft seat";
        String ticketAmountFirstTime = "1";
        String ticketPrice = "125000";
        String ticketAmountSecondTime = "10";
        int currentTicketAmount = Integer.valueOf(ticketAmountFirstTime);
        int remainTicketAmount = 10 - currentTicketAmount;

        Ticket ticketFirstTime = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmountFirstTime, ticketPrice);
        Ticket ticketSecondTime = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmountSecondTime, ticketPrice);

        bookTicketPage.bookTicket(ticketFirstTime);
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(ticketSecondTime);

        String actualGeneralErrorMsg = bookTicketPage.getGeneralErrorMsg();
        String expectGeneralErrorMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualGeneralErrorMsg, expectGeneralErrorMsg);

        String actualSpecificErrorMsg = bookTicketPage.getSpecificErrorMsg();
        String expectSpecificErrorMsg = "You have booked " + currentTicketAmount + " ticket(s). You can only book " + remainTicketAmount + " more.";

        Assert.assertEquals(actualSpecificErrorMsg, expectSpecificErrorMsg);
    }
}
