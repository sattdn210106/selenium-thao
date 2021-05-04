package tests;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can't login with blank Username text box")
    public void TC002() {
        loginPage.gotoLoginPage();

        String blankUsername = "";
        loginPage.login(blankUsername, Constant.PASSWORD);

        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        String actualErrorMsg = loginPage.getErrorMsg();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is incorrect.");
    }
}
