package tests;

import common.Constant;
import common.helpers.Common;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

import java.io.IOException;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        registerPage.gotoRegisterPage();
    }

    @Test
    public void TC001() throws IOException, ParseException {
        System.out.println("TC001: User can register an account");

        JSONArray accountList = Common.getJsonData(Constant.JSON_PATH + "registerData.json");

        for (int i = 0; i < accountList.size(); i++) {
            JSONObject user = (JSONObject) accountList.get(i);

            String email = (String) user.get("Email");
            String password = (String) user.get("Password");
            String confirmPassword = (String) user.get("Confirm Password");
            String pid = (String) user.get("PID");

            registerPage.register(email, password, confirmPassword, pid);

            String expectedSuccessMsg = "Registration Confirmed! You can now log in to the site.";
            String actualSuccessMsg = registerPage.getRegisterSuccessfullyMsg();
            Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Successful register message is incorrect.");
        }
    }
}
