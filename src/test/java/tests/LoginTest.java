package tests;

import common.constants.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
        homePage.gotoLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        if (homePage.doesTabLogoutExist()) {
            homePage.logout();
        }
    }

    @Test
    public void TC001() {
        System.out.println("TC001: User can login with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String expectedWelcomeMsg = "Welcome " + Constant.USERNAME;
        String actualWelcomeMsg = homePage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeMsg, expectedWelcomeMsg, "Welcome message is incorrect.");
    }

    @Test
    public void TC002() {
        System.out.println("TC002: Error message displays when login with invalid email");
        loginPage.login("thaocute", Constant.PASSWORD);
        String actualErrorMsg = loginPage.getErrorMsg().trim();
        String expectedErrorMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}
