package page_objects;

import common.constants.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //Locators
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@type='submit']");
    private final By lblErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //Elements
    private WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    private WebElement getLblErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorMsg);
    }

    //Methods
    public void login(String username, String password) {
        this.getTxtEmail().clear();
        this.getTxtEmail().sendKeys(username);
        this.getTxtPassword().clear();
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public String getErrorMsg() {
        return this.getLblErrorMsg().getText();
    }
}
