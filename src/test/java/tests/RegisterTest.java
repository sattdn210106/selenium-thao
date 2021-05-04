package tests;

import common.Constant;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can register an account")
    public void TC001() {
        Account account = new Account();

        registerPage.gotoRegisterPage();
        registerPage.register(account);

        String actualSuccessMsg = registerPage.getSuccessfulRegisterMsg();
        String expectSuccessMsg = "Registration Confirmed! You can now log in to the site.";

        Assert.assertEquals(actualSuccessMsg, expectSuccessMsg, "Success message is incorrect");
    }

    @Test(description = "Error message is displayed when register with incorrect format email")
    public void TC002() {
        String invalidEmail = "dangthao7855@gmail";
        Account account = new Account();
        account.setEmail(invalidEmail);

        registerPage.gotoRegisterPage();
        registerPage.register(account);

        String actualGeneralErrorMsg = registerPage.getGeneralErrorMsg();

        String actualSpecificErrorMsg = registerPage.getSpecificErrorMsg();
        String expectSpecificErrorMsg = "Invalid email address";

        Assert.assertEquals(actualGeneralErrorMsg, Constant.GENERAL_ERROR_MSG, "General error message is incorrect");
        Assert.assertEquals(actualSpecificErrorMsg, expectSpecificErrorMsg, "Specific error message is incorrect");
    }

    @Test(description = "Error message is displayed when register with blank email field")
    public void TC003() {
        String invalidEmail = "";

        Account account = new Account();
        account.setEmail(invalidEmail);

        registerPage.gotoRegisterPage();
        registerPage.register(account);

        String actualGeneralErrorMsg = registerPage.getGeneralErrorMsg();

        String actualSpecificErrorMsg = registerPage.getSpecificErrorMsg();
        String expectSpecificErrorMsg = "Invalid email length";

        Assert.assertEquals(actualGeneralErrorMsg, Constant.GENERAL_ERROR_MSG, "General error message is incorrect");
        Assert.assertEquals(actualSpecificErrorMsg, expectSpecificErrorMsg, "Specific error message is incorrect");
    }
}
