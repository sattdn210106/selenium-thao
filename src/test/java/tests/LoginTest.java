package tests;

import com.google.gson.Gson;
import common.Constant;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.FileNotFoundException;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void beforeMethod() {
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

    @Test
    public void TC003() {
        System.out.println("TC003: Error message displays when login with invalid password");
        loginPage.login(Constant.USERNAME, "abcd1234");
        String actualErrorMsg = loginPage.getErrorMsg().trim();
        String expectedErrorMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}
