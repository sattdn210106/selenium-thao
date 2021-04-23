package tests;

import common.Constant;
import common.helpers.Common;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class BookTicketTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
    }

    @Test
    public void TC001() {
        System.out.println("TC001: User can book a ticket");

        String departDate = Common.plusDayFromNow(5);
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Soft seat";
        String ticketAmount = "1";

        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);
    }
}
