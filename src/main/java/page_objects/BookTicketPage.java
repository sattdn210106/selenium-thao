package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage {
    //Dynamic xpath
    String dynamicTableCell = "//td[count(//th[text()='%s']/preceding-sibling::th)+1]";

    //Locators
    private final By cboDepartDate = By.name("Date");
    private final By cboDepartFrom = By.name("DepartStation");
    private final By cboArriveAt = By.name("ArriveStation");
    private final By cboSeatType = By.name("SeatType");
    private final By cboTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.cssSelector("input[value='Book ticket']");
    private final By tblTicketInformation = By.className("MyTable");

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

    private WebElement getTblTicketInformation() {
        return BrowserHelper.getDriver().findElement(tblTicketInformation);
    }

    private WebElement getTableCell(String header) {
        return getTblTicketInformation().findElement(By.xpath(String.format(dynamicTableCell, header)));
    }

    //Methods
    public void bookTicket(Ticket ticket) {
        ElementHelper.scrollToView(getBtnBookTicket());

        ElementHelper.selectDropdownOptionByText(getCboDepartFrom(), ticket.getDepartFrom());

        ElementHelper.selectDropdownOptionByText(getCboDepartDate(), ticket.getDepartDate());

        ElementHelper.selectDropdownOptionByText(getCboSeatType(), ticket.getSeatType());

        ElementHelper.selectDropdownOptionByText(getCboTicketAmount(), ticket.getTicketAmount());

        ElementHelper.selectDropdownOptionByText(getCboArriveAt(), ticket.getArriveAt());

        getBtnBookTicket().click();
    }

    public String getTableCellValue(String header) {
        return getTableCell(header).getText();
    }

    public Ticket getTicketInformation() {
        Ticket ticket = new Ticket();

        ticket.setDepartFrom(getTableCellValue("Depart Station"));
        ticket.setArriveAt(getTableCellValue("Arrive Station"));
        ticket.setBookDate(getTableCellValue("Book Date"));
        ticket.setExpiredDate(getTableCellValue("Expired Date"));
        ticket.setDepartDate(getTableCellValue("Depart Date"));
        ticket.setExpiredDate(getTableCellValue("Expired Date"));
        ticket.setTicketAmount(getTableCellValue("Amount"));
        ticket.setTicketPrice(getTableCellValue("Total Price"));
        ticket.setSeatType(getTableCellValue("Seat Type"));

        return ticket;
    }

    public String getDepartFromSelectedValue() {
        return ElementHelper.getDropDownSelectedOption(getCboDepartFrom()).getText();
    }

    public String getArriveAtSelectedValue() {
        return ElementHelper.getDropDownSelectedOption(getCboArriveAt()).getText();
    }
}
