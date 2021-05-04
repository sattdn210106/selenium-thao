package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends BasePage {
    //Dynamic xpath
    String dynamicTableCell = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";

    //Locators
    private By tblTicketInformation = By.xpath("//table[@class='MyTable']");
    private By pnlFilter = By.className("Filter");
    private By cboDepartStation = By.xpath("//select[@name='FilterDpStation']");
    private By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");
    private By tableRows = By.cssSelector("tr");

    //Elements
    private WebElement getTblTicketInformation() {
        return BrowserHelper.getDriver().findElement(tblTicketInformation);
    }

    private WebElement getPnlFilter() {
        return BrowserHelper.getDriver().findElement(pnlFilter);
    }

    private WebElement getCboDepartStation() {
        return getPnlFilter().findElement(cboDepartStation);
    }

    private WebElement getBtnApplyFilter() {
        return getPnlFilter().findElement(btnApplyFilter);
    }

    private List<WebElement> getTableRows() {
        return getTblTicketInformation().findElements(tableRows);
    }

    //Methods
    public boolean doesFilterPanelExist() {
        return ElementHelper.doesElementExist(pnlFilter);
    }

    public void filterWithDepartStation(String departStation) {
        ElementHelper.selectDropdownOptionByText(getCboDepartStation(), departStation);
        getBtnApplyFilter().click();
    }

    public int getRowAmountIgnoreHeader() {
        return getTableRows().size() - 1;
    }

    public boolean doesTicketDisplayInTable(Ticket ticket) {
        return ElementHelper.doesElementExist(By.xpath(String.format(dynamicTableCell, ticket.getDepartFrom(),
                ticket.getArriveAt(), ticket.getSeatType(), ticket.getDepartDate(), ticket.getTicketAmount())));
    }
}
