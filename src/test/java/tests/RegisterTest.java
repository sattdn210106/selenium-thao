package tests;

import common.helpers.DataHelper;
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

    @Test(description = "User can register an account")
    public void TC001() throws IOException, ParseException {
        String email = DataHelper.randomEmail();
        String password = DataHelper.randomText();
        String confirmPassword = password;
        String pid = DataHelper.randomPID();

        registerPage.register(email, password, confirmPassword, pid);

        String actualSuccessMsg = registerPage.getRegisterSuccessfullyMsg();
        String expectSuccessMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualSuccessMsg, expectSuccessMsg, "Success message is incorrect");
    }
}
