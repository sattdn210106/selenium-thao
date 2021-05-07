package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManageTicketPage extends BasePage {

    //Locators
    private final By tblTicketInformation = By.className("MyTable");
    private final By btnCancel = By.cssSelector(".MyTable input");
    private final By tableRow = By.cssSelector(".MyTable tr");

    //Elements
    private WebElement getTblTicketInformation() {
        return BrowserHelper.getDriver().findElement(tblTicketInformation);
    }

    private WebElement getBtnCancel() {
        return BrowserHelper.getDriver().findElement(btnCancel);
    }

    private List<WebElement> getTableRows() {
        return getTblTicketInformation().findElements(tableRow);
    }

    //Methods
    public void cancelTicket() {
        ElementHelper.scrollToView(getBtnCancel());
        getBtnCancel().click();

        BrowserHelper.waitForAlert();
        BrowserHelper.acceptAlert();
    }

    public int getTableRowAmount() {
        try {
            return getTableRows().size() - 1;
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}
