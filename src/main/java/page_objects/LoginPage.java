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
    private WebElement getEmailTextbox() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    private WebElement getPasswordTextbox() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getLoginButton() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    private WebElement getErrorMsgLabel() {
        return Constant.WEBDRIVER.findElement(lblErrorMsg);
    }

    //Methods
    public void login(String username, String password) {
        this.getEmailTextbox().clear();
        this.getEmailTextbox().sendKeys(username);
        this.getPasswordTextbox().clear();
        this.getPasswordTextbox().sendKeys(password);
        this.getLoginButton().click();
    }

    public String getErrorMsg() {
        return this.getErrorMsgLabel().getText();
    }
}
