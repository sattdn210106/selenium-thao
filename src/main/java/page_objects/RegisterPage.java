package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    //Locators
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.cssSelector("input[title=Register]");
    private final By lblSuccessfulRegisterMsg = By.cssSelector("#content>p");
    private final By lblGeneralErrorMsg = By.cssSelector("p.error");
    private final By lblPasswordErrorMsg = By.cssSelector(".password .validation-error");
    private final By lblPidErrorMsg = By.cssSelector(".pid-number .validation-error");

    //Elements
    private WebElement getTxtEmail() {
        return BrowserHelper.getDriver().findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return BrowserHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return BrowserHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getTxtPid() {
        return BrowserHelper.getDriver().findElement(txtPid);
    }

    private WebElement getBtnRegister() {
        return BrowserHelper.getDriver().findElement(btnRegister);
    }

    private WebElement getLblSuccessfulRegisterMsg() {
        return BrowserHelper.getDriver().findElement(lblSuccessfulRegisterMsg);
    }

    private WebElement getLblGeneralErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblGeneralErrorMsg);
    }

    private WebElement getLblPasswordErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblPasswordErrorMsg);
    }

    private WebElement getLblPidErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblPidErrorMsg);
    }

    //Methods
    public void register(Account account) {
        getTxtEmail().sendKeys(account.getEmail());

        getTxtPassword().sendKeys(account.getPassword());

        getTxtConfirmPassword().sendKeys(account.getConfirmPassword());

        getTxtPid().sendKeys(account.getPid());

        ElementHelper.scrollToView(getBtnRegister());
        this.getBtnRegister().click();
    }

    public String getSuccessfulRegisterMsg() {
        return getLblSuccessfulRegisterMsg().getText();
    }

    public String getGeneralErrorMsg() {
        return getLblGeneralErrorMsg().getText();
    }

    public String getPasswordErrorMsg() {
        return getLblPasswordErrorMsg().getText();
    }

    public String getPidErrorMsg() {
        return getLblPidErrorMsg().getText();
    }
}
