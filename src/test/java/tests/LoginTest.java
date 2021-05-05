package tests;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.ManageTicketPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ManageTicketPage manageTicketPage = new ManageTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

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

        String blankUsername = "";

        loginPage.login(blankUsername, Constant.PASSWORD);

        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        String actualErrorMsg = loginPage.getErrorMsg();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is incorrect.");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC003() {
        homePage.gotoLoginPage();

        String invalidPassword = "987654321";

        loginPage.login(Constant.USERNAME, invalidPassword);

        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        String actualErrorMsg = loginPage.getErrorMsg();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is incorrect.");
    }

    @Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
    public void TC004() {
        homePage.gotoBookTicketPage();

        String expectedLoginPageHeader = "Login Page";
        String actualPageHeader = loginPage.getPageHeader();

        Assert.assertEquals(actualPageHeader, expectedLoginPageHeader, "Login page doesn't display");
    }

    @Test(description = "Additional pages display once user logged in")
    public void TC006() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Assert.assertTrue(homePage.doesTabMyTicketExist());
        Assert.assertTrue(homePage.doesTabLogoutExist());
        Assert.assertTrue(homePage.doesChangePasswordExist());

        homePage.gotoManageTicketPage();

        String expectedManageTicketPageHeader = "Manage Tickets";
        String actualPageHeader = manageTicketPage.getPageHeader();

        Assert.assertEquals(actualPageHeader, expectedManageTicketPageHeader, "Manage Ticket page doesn't display");

        homePage.gotoChangePasswordPage();

        String expectedChangePasswordPageHeader = "Change password";
        actualPageHeader = changePasswordPage.getPageHeader();

        Assert.assertEquals(actualPageHeader, expectedChangePasswordPageHeader, "Change Password page doesn't display");
    }
}
