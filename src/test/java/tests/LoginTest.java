package tests;

import common.Constant;
import common.helpers.DataProviderHelper;
import common.helpers.Log;
import models.LoginData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.gotoLoginPage();
    }

    @Test(description = "User can login with valid account")
    public void TC001() {
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String expectedWelcomeMsg = "Welcome " + Constant.USERNAME;
        String actualWelcomeMsg = homePage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeMsg, expectedWelcomeMsg, "Welcome message is incorrect.");
    }

    @Test(description = "Error message displays when login with invalid account", dataProvider = "invalidLoginData", dataProviderClass = DataProviderHelper.class)
    public void TC002(LoginData loginData) {
        loginPage.login(loginData.getEmail(), loginData.getPassword());

        String actualErrorMsg = loginPage.getErrorMsg().trim();
        String expectedErrorMsg = loginData.getMessage();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is incorrect");
    }
}
