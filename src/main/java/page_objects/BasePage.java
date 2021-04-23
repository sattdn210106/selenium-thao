package page_objects;

import common.constants.Constant;
import common.helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
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
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']");

    //Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabTicketPrice() {
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
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

    public boolean doesTabLogoutExist() {
        try {
            ElementHelper.waitElementExist(tabLogout, Constant.WAIT_ELEMENT_TIME);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
