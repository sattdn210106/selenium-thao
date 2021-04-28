package page_objects;

import common.Constant;
import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class BookTicketPage extends BasePage {
    //Dynamic xpath
    String xpathLblTicketInformation = "//table[@class='MyTable WideTable']//td[count(//th[text()='%s']/preceding-sibling::th)+1 ]";

    //Locators
    private final By cboDepartDate = By.name("Date");
    private final By cboDepartFrom = By.name("DepartStation");
    private final By cboArriveAt = By.name("ArriveStation");
    private final By cboSeatType = By.name("SeatType");
    private final By cboTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.cssSelector("input[value='Book ticket']");
    private final By lblGeneralErrorMsg = By.cssSelector("p.message.error");
    private final By lblSpecificErrorMsg = By.cssSelector("label.validation-error");
    private By getLblTicketInformationLocator(String text) {
        return By.xpath(String.format(xpathLblTicketInformation, text));
    }

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

    private WebElement getLblGeneralErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblGeneralErrorMsg);
    }

    private WebElement getLblSpecificErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblSpecificErrorMsg);
    }

    private WebElement getLblTicketInformation (String text) {
        return BrowserHelper.getDriver().findElement(getLblTicketInformationLocator(text));
    }

    //Methods
    public void bookTicket(Ticket ticket) {

        ElementHelper.selectDropdownOptionByText(getCboDepartFrom(), ticket.getDepartFrom());

        ElementHelper.selectDropdownOptionByText(getCboDepartDate(), ticket.getDepartDate());

        ElementHelper.selectDropdownOptionByText(getCboSeatType(), ticket.getSeatType());

        ElementHelper.selectDropdownOptionByText(getCboTicketAmount(), ticket.getTicketAmount());

        ElementHelper.selectDropdownOptionByText(getCboArriveAt(), ticket.getArriveAt());

        ElementHelper.scrollToView(getBtnBookTicket());
        getBtnBookTicket().click();
    }

    public String getGeneralErrorMsg() {
        return getLblGeneralErrorMsg().getText();
    }

    public String getSpecificErrorMsg() {
        return getLblSpecificErrorMsg().getText();
    }

    public String getTicketInformation(String information) {
        return getLblTicketInformation(information).getText();
    }

    public Map<String, String> getAllTicketInformation() {
        Map<String, String> informationTicket = new HashMap<>();
        for (String header : Constant.HEADER_OF_TABLE) {
            informationTicket.put(header, getTicketInformation(header));
        }
        return informationTicket;
    }
}
