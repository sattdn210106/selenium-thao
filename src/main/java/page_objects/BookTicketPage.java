package page_objects;

import common.Constant;
import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import common.helpers.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage {
    //Locators
    private final By cboDepartDate = By.name("Date");
    private final By cboDepartFrom = By.name("DepartStation");
    private final By cboArriveAt = By.name("ArriveStation");
    private final By cboSeatType = By.name("SeatType");
    private final By cboTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.cssSelector("input[value='Book ticket']");

    //Elements
    private WebElement getCboDepartDate() {
        return Constant.WEBDRIVER.findElement(cboDepartDate);
    }

    private WebElement getCboDepartFrom() {
        return Constant.WEBDRIVER.findElement(cboDepartFrom);
    }

    private WebElement getCboArriveAt() {
        return Constant.WEBDRIVER.findElement(cboArriveAt);
    }

    private WebElement getCboSeatType() {
        return Constant.WEBDRIVER.findElement(cboSeatType);
    }

    private WebElement getCboTicketAmount() {
        return Constant.WEBDRIVER.findElement(cboTicketAmount);
    }

    private WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    //Methods
    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {

        ElementHelper.selectDropdownOptionByText(getCboDepartDate(), departDate);
        Log.info("Selected data in Depart Date is "+ departDate);

        ElementHelper.selectDropdownOptionByText(getCboDepartFrom(), departFrom);
        Log.info("Selected data in Depart From is "+ departFrom);

        ElementHelper.selectDropdownOptionByText(getCboArriveAt(), arriveAt);
        Log.info("Selected data in Arrive At is "+ arriveAt);

        ElementHelper.selectDropdownOptionByText(getCboSeatType(), seatType);
        Log.info("Selected data in Seat Type is "+ seatType);

        ElementHelper.selectDropdownOptionByText(getCboTicketAmount(), ticketAmount);
        Log.info("Selected data in Ticket Amount is "+ ticketAmount);

        ElementHelper.scrollToView(getBtnBookTicket());
        Log.info("Scroll to book ticket button");

        getBtnBookTicket().click();
        Log.info("Ticket button is clicked");
    }
}
