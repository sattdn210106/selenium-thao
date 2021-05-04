package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    //Locators
    private final By tabLogin = By.xpath("//span[text()='Login']");
    private final By tabLogout = By.xpath("//span[text()='Log out']");
    private final By tabHome = By.xpath("//span[text()='Home']");
    private final By tabTimeTable = By.xpath("//span[text()='Ticket price']");
    private final By tabBookTicket = By.xpath("//span[text()='Book ticket']");
    private final By tabRegister = By.xpath("//span[text()='Register']");
    private final By tabTicketPrice = By.xpath("//span[text()='Ticket price']");
    private final By tabContact = By.xpath("//span[text()='Contact']");
    private final By tabFAQ = By.xpath("//span[text()='FAQ']");
    private final By tabMyTicket = By.xpath("//span[text()='My ticket']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']");

    //Elements
    private WebElement getTabLogin() {
        return BrowserHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getTabLogout() {
        return BrowserHelper.getDriver().findElement(tabLogout);
    }

    private WebElement getLblWelcomeMessage() {
        return BrowserHelper.getDriver().findElement(lblWelcomeMessage);
    }

    private WebElement getTabTimeTable() {
        return BrowserHelper.getDriver().findElement(tabTimeTable);
    }

    private WebElement getTabBookTicket() {
        return BrowserHelper.getDriver().findElement(tabBookTicket);
    }

    private WebElement getTabRegister() {
        return BrowserHelper.getDriver().findElement(tabRegister);
    }

    private WebElement getTabTicketPrice() {
        return BrowserHelper.getDriver().findElement(tabTicketPrice);
    }

    private WebElement getTabMyTicket() {
        return BrowserHelper.getDriver().findElement(tabMyTicket);
    }


    //Methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void logout() {
        this.getTabLogout().click();
    }

    public void gotoTimeTablePage() {
        this.getTabTimeTable().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoMyTicketPage() {this.getTabMyTicket().click();}

    public boolean doesTabLogoutExist() {
        return ElementHelper.doesElementExist(tabLogout);
    }

    public String getPageTitle() {
        return BrowserHelper.getDriver().getTitle().trim();
    }
}
