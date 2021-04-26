package page_objects;

import common.Constant;
import common.helpers.ElementHelper;
import common.helpers.Log;
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
        ElementHelper.input(getTxtEmail(), username);
        Log.info("Data is inputted in Email textbox is"+ username);

        ElementHelper.input(getTxtPassword(), password);
        Log.info("Data is inputted in Password textbox is"+ password);

        this.getBtnLogin().click();
        Log.info("Login button is clicked");
    }

    public String getErrorMsg() {
        Log.info("Get error message");
        return this.getLblErrorMsg().getText();
    }
}
