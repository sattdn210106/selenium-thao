package page_objects;

import common.constants.Constant;
import common.helpers.BrowserHepler;
import common.helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    //Locators
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmLPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.cssSelector("input[value=Register]");
    private final By lblRegisterSuccessfullyMsg = By.cssSelector("div[id=content]>p");


    //Elements
    private WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmLPassword);
    }

    private WebElement getTxtPid() {
        return Constant.WEBDRIVER.findElement(txtPid);
    }

    private WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    private WebElement getLblRegisterSuccessfullyMsg() {
        return Constant.WEBDRIVER.findElement(lblRegisterSuccessfullyMsg);
    }

    //Methods/
    public void register(String username, String password, String confirmPassword, String pid) {
        this.getTxtEmail().clear();
        this.getTxtEmail().sendKeys(username);

        this.getTxtPassword().clear();
        this.getTxtPassword().sendKeys(password);

        this.getTxtConfirmPassword().clear();
        this.getTxtConfirmPassword().sendKeys(confirmPassword);

        this.getTxtPid().clear();
        this.getTxtPid().sendKeys(pid);

        BrowserHepler.scrollToView(getBtnRegister());
        this.getBtnRegister().click();
    }

    public String getRegisterSuccessfullyMsg() {
        return getLblRegisterSuccessfullyMsg().getText();
    }
}
