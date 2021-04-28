package page_objects;

import common.Constant;
import common.helpers.BrowserHelper;
import common.helpers.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuccessPage {
    //Dynamic locators xpath
    String xpathLblHeaderColumnTbl = "//tr[@class='TableSmallHeader']//th[text()='<text>']";

    //Locators
    private final By tblTicket = By.className("MyTable WideTable");
    private final By lblHeaderTbl = By.cssSelector(".TableSmallHeader > th");
    private final By lblInformationTicket = By.cssSelector(".OddRow > td");
    private By getLblHeaderColumnTblLocator (String text) {
        return By.xpath(xpathLblHeaderColumnTbl.replace("<text>", text));
    }

    //Elements
    private WebElement getTblTicket() {
        return BrowserHelper.getDriver().findElement(tblTicket);
    }

    private List<WebElement> getHeaderTable() {
        return BrowserHelper.getDriver().findElements(lblHeaderTbl);
    }

    private List<WebElement> getLblInformationTicketTbl() {
        return BrowserHelper.getDriver().findElements(lblInformationTicket);
    }

    private WebElement getLblHeaderColumnTbl(String text) {
        return BrowserHelper.getDriver().findElement(getLblHeaderColumnTblLocator(text));
    }

    //Methods
    public String getInformationTicket(String information) {
        int index = getHeaderTable().indexOf(getLblHeaderColumnTbl(information));
        return getLblInformationTicketTbl().get(index).getText();
    }

    public WebElement getLblHeaderTblElement(String header) {
        return BrowserHelper.getDriver().findElement(By.xpath("//tr[@class='TableSmallHeader']//th[text()='"+ header + "']"));
    }

    public Map<String, String> getAllInformationTicket() {
        Map<String, String> informationTicket = new HashMap<>();
        for (String header : Constant.HEADER_TABLE) {
            informationTicket.put(header, getInformationTicket(header));
        }
        return informationTicket;
    }
}
