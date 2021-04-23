package tests;

import common.Constant;
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
        bookTicketPage.bookTicket(Constant.DEPART_DATE, Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT);
    }
}
