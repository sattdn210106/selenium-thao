package tests;

import common.Common;
import common.Constant;
import models.Account;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

import java.util.ArrayList;
import java.util.List;

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
        String departDate = Common.plusDayFromNow(5, Constant.DATE_FORMAT);
        String departStation = "Đà Nẵng";
        String seatType = "Soft seat";
        String ticketAmount = "1";

        Ticket ticket1 = new Ticket(departDate, "Nha Trang", "Phan Thiết", seatType, ticketAmount, "125000");
        Ticket ticket2 = new Ticket(departDate, "Phan Thiết", "Sài Gòn", seatType, ticketAmount, "115000");
        Ticket ticket3 = new Ticket(departDate, "Sài Gòn", "Đà Nẵng", seatType, ticketAmount, "335000");
        Ticket ticket4 = new Ticket(departDate, "Đà Nẵng", "Nha Trang", seatType, ticketAmount, "135000");
        Ticket ticket5 = new Ticket(departDate, "Đà Nẵng", "Sài Gòn", seatType, ticketAmount, "335000");
        Ticket ticket6 = new Ticket(departDate, "Đà Nẵng", "Quảng Ngãi", seatType, ticketAmount, "325000");

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        registerPage.gotoRegisterPage();

        Account account = new Account();
        registerPage.register(account);

        loginPage.gotoLoginPage();
        loginPage.login(account.getEmail(), account.getPassword());

        bookTicketPage.bookTicketMultipleTimes(tickets);

        myTicketPage.gotoMyTicketPage();

        myTicketPage.filterWithDepartStation(departStation);

        int expectFilteredTicketAmount = 3;
        int actualFilteredTicketAmount = myTicketPage.getRowAmountIgnoreHeader();
        Assert.assertEquals(actualFilteredTicketAmount, expectFilteredTicketAmount, "Amount of filtered ticket is incorrect");

        Assert.assertTrue(myTicketPage.doesTicketDisplayInTable(ticket4), "Ticket doesn't display.");
        Assert.assertTrue(myTicketPage.doesTicketDisplayInTable(ticket5), "Ticket doesn't display.");
        Assert.assertTrue(myTicketPage.doesTicketDisplayInTable(ticket6), "Ticket doesn't display.");
    }
}
