package tests;

import common.Common;
import common.Constant;
import models.Account;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class BookTicketTest extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "User can book 1 ticket at a time")
    public void TC014() {
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

        Ticket expectedTicket = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmount, ticketPrice);

        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(expectedTicket);

        String expectedPageHeader = "Ticket Booked Successfully!";
        String actualPageHeader = bookTicketPage.getPageHeader();


        Assert.assertEquals(actualPageHeader, expectedPageHeader, "Page header is incorrect");

        Ticket actualTicket = bookTicketPage.getTicketInformation();

        Assert.assertEquals(actualTicket.getDepartFrom(), expectedTicket.getDepartFrom(), "Depart station is incorrect");
        Assert.assertEquals(actualTicket.getArriveAt(), expectedTicket.getArriveAt(), "Arrive station is incorrect");
        Assert.assertEquals(actualTicket.getSeatType(), expectedTicket.getSeatType(), "Seat type is incorrect");
        Assert.assertEquals(actualTicket.getBookDate(), expectedTicket.getBookDate(), "Book date is incorrect");
        Assert.assertEquals(actualTicket.getDepartDate(), expectedTicket.getDepartDate(), "Depart date is incorrect");
        Assert.assertEquals(actualTicket.getExpiredDate(), expectedTicket.getExpiredDate(), "Expired date is incorrect");
        Assert.assertEquals(actualTicket.getTicketAmount(), expectedTicket.getTicketAmount(), "Ticket amount is incorrect");
        Assert.assertEquals(actualTicket.getTicketPrice(), expectedTicket.getTicketPrice(), "Ticket price is incorrect");
    }
}
