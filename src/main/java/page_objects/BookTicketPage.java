package page_objects;

import common.Constant;
import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import common.helpers.Log;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage {
    //Locators
    private final By cboDepartDate = By.name("Date");
    private final By cboDepartFrom = By.name("DepartStation");
    private final By cboArriveAt = By.name("ArriveStation");
    private final By cboSeatType = By.name("SeatType");
    private final By cboTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.cssSelector("input[value='Book ticket']");

    //Elements
    private WebElement getCboDepartDate() {
        return BrowserHelper.getDriver().findElement(cboDepartDate);
    }

    private WebElement getCboDepartFrom() {
        return BrowserHelper.getDriver().findElement(cboDepartFrom);
    }

    private WebElement getCboArriveAt() {
        return BrowserHelper.getDriver().findElement(cboArriveAt);
    }

    private WebElement getCboSeatType() {
        return BrowserHelper.getDriver().findElement(cboSeatType);
    }

    private WebElement getCboTicketAmount() {
        return BrowserHelper.getDriver().findElement(cboTicketAmount);
    }

    private WebElement getBtnBookTicket() {
        return BrowserHelper.getDriver().findElement(btnBookTicket);
    }

    //Methods
    public void bookTicket(Ticket ticket) {

        ElementHelper.selectDropdownOptionByText(getCboDepartFrom(), ticket.getDepartFrom());
        Log.info("Selected data in Depart From is "+ ticket.getDepartFrom());

        ElementHelper.selectDropdownOptionByText(getCboDepartDate(), ticket.getDepartDate());
        Log.info("Selected data in Depart Date is "+ ticket.getDepartDate());

        ElementHelper.selectDropdownOptionByText(getCboSeatType(), ticket.getSeatType());
        Log.info("Selected data in Seat Type is "+ ticket.getSeatType());

        ElementHelper.selectDropdownOptionByText(getCboTicketAmount(), ticket.getTicketAmount());
        Log.info("Selected data in Ticket Amount is "+ ticket.getTicketAmount());

        ElementHelper.selectDropdownOptionByText(getCboArriveAt(), ticket.getArriveAt());
        Log.info("Selected data in Arrive At is "+ ticket.getArriveAt());

        ElementHelper.scrollToView(getBtnBookTicket());
        getBtnBookTicket().click();
    }
}
