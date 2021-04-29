package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends BasePage {
    //Dynamic xpath
    String dynamicTableRow = "//td[count(//table[@class='MyTable']//th[text()='%s']//preceding-sibling::th)+1 and text()='%s']//parent::tr";

    //Locators
    private By tblTicketInformation = By.xpath("//table[@class='MyTable']");
    private By pnlFilter = By.className("Filter");
    private By cboDepartStation = By.xpath("//select[@name='FilterDpStation']");
    private By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");

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

    private List<WebElement> getTableRowValues(String columnHeader, String value) {
        return getTblTicketInformation().findElements(By.xpath(String.format(dynamicTableRow, columnHeader, value)));
    }

    private WebElement getBtnApplyFilter() {
        return getPnlFilter().findElement(btnApplyFilter);
    }

    //Methods
    public boolean doesFilterPanelExist() {
        return ElementHelper.doesElementExist(pnlFilter);
    }

    public int getAmountOfSpecificTicket(String columnHeader, String value) {
        return getTableRowValues(columnHeader, value).size();
    }

    public void filterWithDepartStation(String departStation) {
        ElementHelper.selectDropdownOptionByText(getCboDepartStation(), departStation);
        getBtnApplyFilter().click();
    }
}
