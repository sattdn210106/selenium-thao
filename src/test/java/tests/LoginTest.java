package tests;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(description = "User can log into Railway with valid username and password")
    public void TC001() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String expectedWelcomeMsg = "Welcome " + Constant.USERNAME;
        String actualWelcomeMsg = loginPage.getWelcomeMessage();

        Assert.assertEquals(actualWelcomeMsg, expectedWelcomeMsg, "Welcome message is incorrect.");
    }

    @Test(description = "User can't login with blank Username text box")
    public void TC002() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String blankUsername = "";

        loginPage.login(blankUsername, Constant.PASSWORD);

        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        String actualErrorMsg = loginPage.getErrorMsg();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is incorrect.");
    }
}
