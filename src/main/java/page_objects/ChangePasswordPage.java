package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    //Locators
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.cssSelector("input[title='Change password']");
    private final By lblSuccessfulMsg = By.className("success");

    //Elements
    private WebElement getTxtCurrentPassword() {
        return BrowserHelper.getDriver().findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword() {
        return BrowserHelper.getDriver().findElement(txtNewPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return BrowserHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword() {
        return BrowserHelper.getDriver().findElement(btnChangePassword);
    }

    private WebElement getLblSuccessfulMsg() {
        return BrowserHelper.getDriver().findElement(lblSuccessfulMsg);
    }

    //Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        ElementHelper.scrollToView(getBtnChangePassword());

        getTxtCurrentPassword().sendKeys(currentPassword);
        getTxtNewPassword().sendKeys(newPassword);
        getTxtConfirmPassword().sendKeys(confirmPassword);

        getBtnChangePassword().click();
    }

    public String getSuccessfulMsg() {
        return getLblSuccessfulMsg().getText().trim();
    }
}
