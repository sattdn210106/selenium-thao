package tests;

import common.Constant;
import common.helpers.BrowserHelper;
import common.helpers.DataHelper;
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

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC003() {
        homePage.gotoLoginPage();

        String invalidPassword = DataHelper.getRandomText();

        loginPage.login(Constant.USERNAME, invalidPassword);

        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        String actualErrorMsg = loginPage.getErrorMsg();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is incorrect.");
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Welcome message is incorrect.");
    }

    @Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
    public void TC004() {
        homePage.gotoBookTicketPage();

        String expectedPageTitle = "Safe Railway - Login";
        String actualPageTitle = BrowserHelper.getPageTitle();

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Login page doesn't display");
    }

    @Test(description = "Additional pages display once user logged in")
    public void TC006() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Assert.assertTrue(homePage.doesTabMyTicketExist());
        Assert.assertTrue(homePage.doesTabLogoutExist());
        Assert.assertTrue(homePage.doesChangePasswordExist());

        homePage.gotoMyTicketPage();

        String expectedMyTicketPageTitle = "Safe Railway - My Ticket";
        String actualPageTitle = BrowserHelper.getPageTitle();

        Assert.assertEquals(actualPageTitle, expectedMyTicketPageTitle, "My Ticket page doesn't display");

        homePage.gotoChangePasswordPage();

        String expectedChangePasswordPageTitle = "Safe Railway - Change Password";
        actualPageTitle = BrowserHelper.getPageTitle();

        Assert.assertEquals(actualPageTitle, expectedChangePasswordPageTitle, "Change Password page doesn't display");
    }
}
