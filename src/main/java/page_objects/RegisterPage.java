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
    private final By txtConfirmLPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.cssSelector("input[value=Register]");
    private final By lblRegisterSuccessfullyMsg = By.cssSelector("div[id=content]>p");
    private final By lblGeneralErrorMsg = By.cssSelector("p.message.error");
    private final By lblSpecificErrorMsg = By.cssSelector("label.validation-error");

    //Elements
    private WebElement getTxtEmail() {
        return BrowserHelper.getDriver().findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return BrowserHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return BrowserHelper.getDriver().findElement(txtConfirmLPassword);
    }

    private WebElement getTxtPid() {
        return BrowserHelper.getDriver().findElement(txtPid);
    }

    private WebElement getBtnRegister() {
        return BrowserHelper.getDriver().findElement(btnRegister);
    }

    private WebElement getLblRegisterSuccessfullyMsg() {
        return BrowserHelper.getDriver().findElement(lblRegisterSuccessfullyMsg);
    }

    private WebElement getLblGeneralErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblGeneralErrorMsg);
    }

    private WebElement getLblSpecificErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblSpecificErrorMsg);
    }

    //Methods/
    public void register(Account account) {
        getTxtEmail().sendKeys(account.getEmail());

        getTxtPassword().sendKeys(account.getPassword());

        getTxtConfirmPassword().sendKeys(account.getConfirmPassword());

        getTxtPid().sendKeys(account.getPid());

        ElementHelper.scrollToView(getBtnRegister());
        this.getBtnRegister().click();
    }

    public String getSuccessfulRegisterMsg() {
        return getLblRegisterSuccessfullyMsg().getText();
    }

    public String getGeneralErrorMsg() {
        return getLblGeneralErrorMsg().getText();
    }

    public String getSpecificErrorMsg() {
        return getLblSpecificErrorMsg().getText();
    }
}
