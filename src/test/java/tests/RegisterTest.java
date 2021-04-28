package tests;

import common.Constant;
import common.helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        registerPage.gotoRegisterPage();
    }

    @Test(description = "User can register an account")
    public void TC001() {
        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomText();
        String confirmPassword = password;
        String pid = DataHelper.getRandomPID();

        registerPage.register(email, password, confirmPassword, pid);

        String actualSuccessMsg = registerPage.getRegisterSuccessfullyMsg();
        String expectSuccessMsg = "Registration Confirmed! You can now log in to the site.";

        Assert.assertEquals(actualSuccessMsg, expectSuccessMsg, "Success message is incorrect");
    }

    @Test(description = "Error message is displayed when register with incorrect format email")
    public void TC002() {

        String email = "dangthao7855@gmail";
        String password = DataHelper.getRandomText();
        String pid = DataHelper.getRandomPID();

        registerPage.register(email, password, password, pid);

        String actualGeneralErrorMsg = registerPage.getGeneralErrorMsg();

        String actualSpecificErrorMsg = registerPage.getSpecificErrorMsg();
        String expectSpecificErrorMsg = "Invalid email address";

        Assert.assertEquals(actualGeneralErrorMsg, Constant.GENERAL_ERROR_MSG, "General error message is incorrect");
        Assert.assertEquals(actualSpecificErrorMsg, expectSpecificErrorMsg, "Specific error message is incorrect");
    }

    @Test(description = "Error message is displayed when register with blank email field")
    public void TC003() {

        String email = "";
        String password = DataHelper.getRandomText();
        String pid = DataHelper.getRandomPID();

        registerPage.register(email, password, password, pid);

        String actualGeneralErrorMsg = registerPage.getGeneralErrorMsg();

        String actualSpecificErrorMsg = registerPage.getSpecificErrorMsg();
        String expectSpecificErrorMsg = "Invalid email length";

        Assert.assertEquals(actualGeneralErrorMsg, Constant.GENERAL_ERROR_MSG, "General error message is incorrect");
        Assert.assertEquals(actualSpecificErrorMsg, expectSpecificErrorMsg, "Specific error message is incorrect");
    }
}
