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
}
