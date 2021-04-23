package page_objects;

import org.openqa.selenium.By;

public class SuccessPage {
    //Locators
    private final By cboDepartDate = By.name("Date");
    private final By cboDepartFrom = By.name("DepartStation");
    private final By cboArriveAt = By.name("ArriveStation");
    private final By cboSeatType = By.name("SeatType");
    private final By cboTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.cssSelector("input[value='Book ticket']");
}
