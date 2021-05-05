package page_objects;

import common.helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    //Locators
    private final By tabLogin = By.xpath("//span[text()='Login']");
    private final By lblWelcomeMessage = By.className("account");

    //Elements
    private WebElement getTabLogin() {
        return BrowserHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getLblWelcomeMessage() {
        return BrowserHelper.getDriver().findElement(lblWelcomeMessage);
    }

    //Methods
    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }
}
