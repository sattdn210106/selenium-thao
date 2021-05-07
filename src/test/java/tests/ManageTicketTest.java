package tests;

import common.Common;
import common.Constant;
import models.Account;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;
import page_objects.ManageTicketPage;
import page_objects.RegisterPage;

public class ManageTicketTest extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    ManageTicketPage manageTicketPage = new ManageTicketPage();

    @Test(description = "User can cancel a ticket")
    public void TC016() {
        homePage.gotoRegisterPage();

        Account account = new Account();
        registerPage.register(account);

        registerPage.gotoLoginPage();
        loginPage.login(account.getEmail(), account.getPassword());

        String departDate = Common.plusDayFromNow(5, Constant.DATE_FORMAT);
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Soft bed with air conditioner";
        String ticketAmount = "1";
        String ticketPrice = "420000";

        Ticket ticket = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmount, ticketPrice);

        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(ticket);

        bookTicketPage.gotoManageTicketPage();
        manageTicketPage.cancelTicket();

        int expectedRowAmount = 0;
        int actualRowAmount = manageTicketPage.getTableRowAmount();

        Assert.assertEquals(actualRowAmount, expectedRowAmount, "Ticket isn't canceled");
    }
}
