package page_objects;

import common.constants.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //Locators
    private final By emailTextbox = By.xpath("//input[@id='username']");
    private final By passwordTextbox = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@type='submit']");
    private final By errorMsgLabel = By.xpath("//p[@class='message error LoginForm']");

    //Elements
    private WebElement getEmailTextbox() {
        return Constant.WEBDRIVER.findElement(emailTextbox);
    }

    private WebElement getPasswordTextbox() {
        return Constant.WEBDRIVER.findElement(passwordTextbox);
    }

    private WebElement getLoginButton() {
        return Constant.WEBDRIVER.findElement(loginButton);
    }

    private WebElement getErrorMsgLabel() {
        return Constant.WEBDRIVER.findElement(errorMsgLabel);
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
