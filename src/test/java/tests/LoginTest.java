package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constant;
import common.Common;
import models.LoginData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(description = "User can login with valid account")
    public void TC001() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String expectedWelcomeMsg = "Welcome " + Constant.USERNAME;
        String actualWelcomeMsg = homePage.getWelcomeMessage();

        Assert.assertEquals(actualWelcomeMsg, expectedWelcomeMsg, "Welcome message is incorrect.");
    }

    @Test(description = "Error message displays when login with invalid account", dataProvider = "invalidLoginData")
    public void TC002(LoginData loginData) {
        homePage.gotoLoginPage();
        loginPage.login(loginData.getEmail(), loginData.getPassword());

        String actualErrorMsg = loginPage.getErrorMsg();
        String expectedErrorMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is incorrect");
    }

    @DataProvider(name = "invalidLoginData")
    public Object[] getInvalidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<LoginData> listData = objectMapper.readValue(Common.readFile(Constant.JSON_PATH
                + "loginData.json"), new TypeReference<List<LoginData>>() {
        });

        return listData.toArray();
    }
}
