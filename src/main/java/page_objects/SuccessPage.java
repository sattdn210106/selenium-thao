package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SuccessPage {
    //Locators
    private final By tblTicket = By.className("MyTable WideTable");
    private final By lblHeaderTicketTbl = By.cssSelector(".TableSmallHeader > th");
    private final By lblInformationTicket = By.cssSelector(".OddRow > td");
    private final By lblHeader = By.xpath("//tr[@class='TableSmallHeader']//th[text()='value']");

    //Elements
    private WebElement getTblTicket() {
        return BrowserHelper.getDriver().findElement(tblTicket);
    }

    private List<WebElement> getHeaderTable() {
        return BrowserHelper.getDriver().findElements(lblHeaderTicketTbl);
    }

    private List<WebElement> getLblInformationTicketTbl() {
        return BrowserHelper.getDriver().findElements(lblInformationTicket);
    }

    private WebElement getLblHeader() {
        return BrowserHelper.getDriver().findElement(lblHeader);
    }

    //Methods
    public String getDepartStationInformation() {
        int index = getHeaderTable().indexOf(BrowserHelper.getDriver().findElement(By.xpath("//tr[@class='TableSmallHeader']//th[text()='Depart Station']")));
        System.out.println(index);
        return getLblInformationTicketTbl().get(index).getText();
    }
}
