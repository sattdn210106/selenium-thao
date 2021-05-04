package tests;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginTest {
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can log into Railway with valid username and password")
    public void TC002() {
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String expectedWelcomeMsg = "Welcome " + Constant.USERNAME;
        String actualWelcomeMsg = loginPage.getWelcomeMessage();

        Assert.assertEquals(actualWelcomeMsg, expectedWelcomeMsg, "Welcome message is incorrect.");
    }
}
