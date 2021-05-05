package tests;

import common.helpers.DataHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTest extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    String email = DataHelper.getRandomEmail();
    String expectedGeneralErrorMsg = "There're errors in the form. Please correct the errors and try again.";

    @Test(description = "User can create new account")
    public void TC007() {
        Account account = new Account().getRandomAccount();

        homePage.gotoRegisterPage();
        registerPage.register(account);

        String actualSuccessfulMsg = registerPage.getSuccessfulRegisterMsg();
        String expectSuccessfulMsg = "Thank you for registering your account";

        Assert.assertEquals(actualSuccessfulMsg, expectSuccessfulMsg, "Successful message is incorrect");
    }

    @Test(description = "User can't create account with Confirm Password is not the same with Password")
    public void TC010() {
        String password = "987654321";
        String invalidConfirmPassword = "123456789";
        String pid = DataHelper.getRandomPID();

        Account account = new Account(email, password, invalidConfirmPassword, pid);

        homePage.gotoRegisterPage();
        registerPage.register(account);

        String actualGeneralErrorMsg = registerPage.getGeneralErrorMsg();

        Assert.assertEquals(actualGeneralErrorMsg, expectedGeneralErrorMsg, "General error message is incorrect");
    }

    @Test(description = "User can't create account while Password and PID fields are empty")
    public void TC011() {
        String password = "";
        String pid = "";

        Account account = new Account(email, password, password, pid);

        homePage.gotoRegisterPage();
        registerPage.register(account);

        String actualGeneralErrorMsg = registerPage.getGeneralErrorMsg();

        Assert.assertEquals(actualGeneralErrorMsg, expectedGeneralErrorMsg, "General error message is incorrect");

        String expectedPasswordErrorMsg = "Invalid password length";
        String actualPasswordErrorMsg = registerPage.getPasswordErrorMsg();

        Assert.assertEquals(actualPasswordErrorMsg, expectedPasswordErrorMsg, "The error message displays next to password field is incorrect");

        String expectedPidErrorMsg = "Invalid ID length";
        String actualPidErrorMsg = registerPage.getPidErrorMsg();

        Assert.assertEquals(actualPidErrorMsg, expectedPidErrorMsg, "The error message displays next to password field is incorrect");
    }
}
