package drafts;

import common.Constant;
import common.helpers.Common;
import common.helpers.DataHelper;
import models.Ticket;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import tests.BaseTest;

import javax.xml.bind.Element;
import java.util.List;

public class Draft extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
    }

    @Test(description = "User can book a ticket")
    public void TC001() {

        String departDate = Common.plusDayFromNow(5);
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Soft seat";
        String ticketAmount = "1";

        Ticket ticket = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmount);

        bookTicketPage.bookTicket(ticket);


    }
}