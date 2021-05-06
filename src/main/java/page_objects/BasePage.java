package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    //Locators
    private final By tabLogin = By.xpath("//span[text()='Login']");
    private final By tabRegister = By.xpath("//span[text()='Register']");
    private final By lblWelcomeMessage = By.className("account");
    private final By tabBookTicket = By.xpath("//span[text()='Book ticket']");
    private final By tabMyTicket = By.xpath("//span[text()='My ticket']");
    private final By tabLogout = By.xpath("//span[text()='Log out']");
    private final By tabChangePassword = By.xpath("//span[text()='Change password']");
    private final By tabTimetable = By.xpath("//span[text()='Timetable']");
    private final By lblHeader = By.cssSelector("#content h1");

    //Elements
    private WebElement getTabLogin() {
        return BrowserHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getTabRegister() {
        return BrowserHelper.getDriver().findElement(tabRegister);
    }

    private WebElement getLblWelcomeMessage() {
        return BrowserHelper.getDriver().findElement(lblWelcomeMessage);
    }

    private WebElement getTabBookTicket() {
        return BrowserHelper.getDriver().findElement(tabBookTicket);
    }

    private WebElement getTabMyTicket() {
        return BrowserHelper.getDriver().findElement(tabMyTicket);
    }

    private WebElement getTabLogout() {
        return BrowserHelper.getDriver().findElement(tabLogout);
    }

    private WebElement getTabChangePassword() {
        return BrowserHelper.getDriver().findElement(tabChangePassword);
    }

    private WebElement getTabTimetable() {
        return BrowserHelper.getDriver().findElement(tabTimetable);
    }

    private WebElement getLblHeader() {
        return BrowserHelper.getDriver().findElement(lblHeader);
    }

    //Methods
    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoManageTicketPage() {
        this.getTabMyTicket().click();
    }

    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void gotoTrainTimetablePage() {
        this.getTabTimetable().click();
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public boolean doesTabLogoutExist() {
        return ElementHelper.doesElementExist(tabLogout);
    }

    public boolean doesTabMyTicketExist() {
        return ElementHelper.doesElementExist(tabMyTicket);
    }

    public boolean doesChangePasswordExist() {
        return ElementHelper.doesElementExist(tabChangePassword);
    }

    public String getPageHeader() {
        return getLblHeader().getText();
    }

    public void logout() {
        getTabLogout().click();
    }
}
