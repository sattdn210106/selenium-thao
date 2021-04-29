package tests;

import common.Common;
import common.Constant;
import models.Account;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class MyTicketTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(description = "Filter function is not appear when user books ticket less than 5 times")
    public void TC001() {
        registerPage.gotoRegisterPage();

        Account account = new Account();
        registerPage.register(account);

        loginPage.gotoLoginPage();
        loginPage.login(account.getEmail(), account.getPassword());

        bookTicketPage.gotoBookTicketPage();

        String departDate = Common.plusDayFromNow(5, Constant.DATE_FORMAT);
        String departFrom = "Nha Trang";
        String arriveAt = "Phan Thiết";
        String seatType = "Soft seat";
        String ticketAmount = "1";
        String ticketPrice = "125000";

        Ticket ticket = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmount, ticketPrice);

        bookTicketPage.bookTicketMultipleTimes(ticket, 5);

        myTicketPage.gotoMyTicketPage();

        Assert.assertFalse(myTicketPage.doesFilterPanelExist(), "Filter function is appears.");
    }

    @Test(description = "Verify that user can filter successfully with valid data at Depart Station field")
    public void TC002() {
        String departStation = "Nha Trang";
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        myTicketPage.gotoMyTicketPage();

        int expectedTicketAmount = myTicketPage.getAmountOfSpecificTicket(departStation, "Depart Station");

        myTicketPage.filterWithDepartStation(departStation);

        int actualTicketAmount = myTicketPage.getAmountOfSpecificTicket(departStation, "Depart Station");

        Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Amount of tickets before filter are " + expectedTicketAmount + " don't match with amount of tickets after filter are" + actualTicketAmount);
    }
}
