package page_objects;

import common.Constant;
import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
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
        ElementHelper.selectDropdownOptionByText(getCboDepartFrom(), departFrom);
        ElementHelper.selectDropdownOptionByText(getCboArriveAt(), arriveAt);
        ElementHelper.selectDropdownOptionByText(getCboSeatType(), seatType);
        ElementHelper.selectDropdownOptionByText(getCboTicketAmount(), ticketAmount);

        ElementHelper.scrollToView(getBtnBookTicket());
        getBtnBookTicket().click();
    }
}
