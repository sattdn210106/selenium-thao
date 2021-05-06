package tests;

import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class ChangePasswordTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(description = "User can change password")
    public void TC009() {
        homePage.gotoRegisterPage();
        Account account = new Account();
        registerPage.register(account);

        registerPage.gotoLoginPage();

        String email = account.getEmail();
        String password = account.getPassword();

        loginPage.login(email, password);

        homePage.gotoChangePasswordPage();

        String newPassword = "123456789";
        changePasswordPage.changePassword(password, newPassword, newPassword);

        String expectedSuccessfulMsg = "Your password has been updated!";
        String actualSuccessfulMsg = changePasswordPage.getSuccessfulMsg();

        Assert.assertEquals(actualSuccessfulMsg, expectedSuccessfulMsg, "Successful message is incorrect");

        changePasswordPage.logout();
        homePage.gotoLoginPage();

        loginPage.login(email, newPassword);

        String expectedWelcomeMsg = "Welcome " + email;
        String actualWelcomeMsg = loginPage.getWelcomeMessage();

        Assert.assertEquals(actualWelcomeMsg, expectedWelcomeMsg, "Welcome message is incorrect.");
    }
}
